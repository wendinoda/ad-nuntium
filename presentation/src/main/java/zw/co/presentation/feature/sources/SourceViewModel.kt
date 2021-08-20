package zw.co.presentation.feature.sources

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import zw.co.domain.usecase.sources.GetAllSourcesUseCase
import zw.co.presentation.base.BaseViewModel
import zw.co.presentation.base.BaseState
import zw.co.presentation.base.DispatchersProvider
import zw.co.presentation.error.ErrorHandler
import zw.co.presentation.mapper.SourceMapper
import javax.inject.Inject

@HiltViewModel
class SourceViewModel @Inject constructor(
    private val getAllSourcesUseCase: GetAllSourcesUseCase,
    private val mapper: SourceMapper,
    private val dispatchersProvider: DispatchersProvider,
    private val errorHandler: ErrorHandler,
) : BaseViewModel<BaseState<SourceState>, SourceIntent, SourceEffects>() {
    override fun createInitialState(): BaseState<SourceState> {
        return BaseState(
            SourceState.Idle()
        )
    }

    override fun handleIntent(intent: SourceIntent) {
        when (intent) {
            is SourceIntent.LoadSources -> {
                getSources()
            }
        }
    }

    private fun getSources() {
        viewModelScope.launch(dispatchersProvider.io) {
            setState {
                copy(state = SourceState.InProgress)
            }
            getAllSourcesUseCase.execute()
                .catch { throwable ->
                    setState {
                        copy(SourceState.Error(errorHandler.getError(throwable)))
                    }
                }
                .collect {
                    setState {
                        copy(
                            SourceState.Success(
                                mapper.mapToUi(it)
                            )
                        )
                    }
                }
        }
    }
}