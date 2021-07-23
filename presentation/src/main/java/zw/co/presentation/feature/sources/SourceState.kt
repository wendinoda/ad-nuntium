package zw.co.presentation.feature.sources

import zw.co.presentation.error.ErrorUi
import zw.co.presentation.model.SourcesSuccessView

sealed class SourceState(val inProgress: Boolean = false,
                         val sources: SourcesSuccessView? = null) {
    object InProgress : SourceState(true, null)

    data class Error(val error: ErrorUi) : SourceState()

    data class Success(private val result: SourcesSuccessView?) : SourceState(false, result)

    class Idle : SourceState(false, null)
}