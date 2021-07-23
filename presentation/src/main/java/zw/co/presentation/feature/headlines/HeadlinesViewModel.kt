package zw.co.presentation.feature.headlines

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import zw.co.domain.usecase.headlines.GetAllHeadlinesUseCase
import zw.co.domain.usecase.headlines.GetHeadlinesByCategoryUseCase
import zw.co.presentation.base.BaseViewModel
import zw.co.presentation.base.State
import zw.co.presentation.error.ErrorHandler
import zw.co.presentation.mapper.HeadlinesMapper
import javax.inject.Inject

@HiltViewModel
class HeadlinesViewModel @Inject constructor(
    private val getAllHeadlinesUseCase: GetAllHeadlinesUseCase,
    private val getHeadlinesByCategoryUseCase: GetHeadlinesByCategoryUseCase,
    private val mapper: HeadlinesMapper,
    private val errorHandler: ErrorHandler
) : BaseViewModel<State<HeadlinesState>, HeadlinesIntent, HeadlinesEffects>() {
    override fun createInitialState(): State<HeadlinesState> {
        return State(
            HeadlinesState.Idle()
        )
    }

    override fun handleIntent(intent: HeadlinesIntent) {
        when (intent) {
            is HeadlinesIntent.LoadHeadlines -> {
                getHeadLines()
            }
            is HeadlinesIntent.LoadHeadLinesByCategory -> {
                getHeadlinesByCategoryUseCase()
            }
        }
    }

    private fun getHeadLines() {
        viewModelScope.launch(Dispatchers.IO) {
            setState {
                copy(
                    state = HeadlinesState.InProgress
                )
            }
            getAllHeadlinesUseCase.execute()
                .catch { throwable ->
                    setState {
                        copy(HeadlinesState.Error(errorHandler.getError(throwable)))
                    }
                }
                .collect {
                    setState {
                        copy(
                            HeadlinesState.Success(
                                mapper.mapToUi(it)
                            )
                        )
                    }
                }
        }
    }

    private fun getHeadlinesByCategoryUseCase(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            setState {
                copy(
                    state = HeadlinesState.InProgress
                )
            }
            getHeadlinesByCategoryUseCase.execute(category)
                .catch { throwable ->
                    setState {
                        copy(HeadlinesState.Error(errorHandler.getError(throwable)))
                    }
                }
                .collect {
                    setState {
                        copy(
                            HeadlinesState.Success(
                                mapper.mapToUi(it)
                            )
                        )
                    }
                }
        }
    }
}