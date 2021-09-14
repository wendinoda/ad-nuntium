package zw.co.presentation.feature.headlines

import zw.co.presentation.error.ErrorUi
import zw.co.presentation.model.HeadlinesView

sealed class HeadlinesState(val inProgress: Boolean = false,
                            val headlines: HeadlinesView? = null,
                            val error: ErrorUi? = null)  {
    object InProgress : HeadlinesState(true, null)

    class Error(error: ErrorUi?): HeadlinesState(false, null, error)

    data class Success(private val result: HeadlinesView?) : HeadlinesState(false, result)

    class Idle : HeadlinesState(false, null)
}