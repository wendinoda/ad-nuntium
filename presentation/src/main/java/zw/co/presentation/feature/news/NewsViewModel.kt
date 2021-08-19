package zw.co.presentation.feature.news

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import zw.co.domain.usecase.news.GetNewsStoriesUseCase
import zw.co.presentation.base.BaseState
import zw.co.presentation.base.BaseViewModel
import zw.co.presentation.error.ErrorHandler
import zw.co.presentation.mapper.NewsMapper
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsStoriesUseCase: GetNewsStoriesUseCase,
    private val mapper: NewsMapper,
    private val errorHandler: ErrorHandler
) : BaseViewModel<BaseState<NewsState>, NewsIntent, NewsEffects>() {
    override fun createInitialState(): BaseState<NewsState> {
        return BaseState(
            NewsState.Idle()
        )
    }

    override fun handleIntent(intent: NewsIntent) {
        when (intent) {
            is NewsIntent.LoadNews -> {
                getNewsStories()
            }
        }
    }

    private fun getNewsStories() {
        viewModelScope.launch(Dispatchers.IO) {
            setState {
                copy(
                    state = NewsState.InProgress
                )
            }
            getNewsStoriesUseCase.execute()
                .catch { throwable ->
                    setState {
                        copy(
                            state = NewsState.Error(errorHandler.getError(throwable))
                        )
                    }
                }
                .collect {
                    setState {
                        copy(
                            state = NewsState.Success(
                                mapper.mapToUi(it)
                            )
                        )
                    }
                }
        }
    }
}