package zw.co.presentation.feature.news

import zw.co.presentation.error.ErrorUi
import zw.co.presentation.model.NewsView

sealed class NewsState(
    val inProgress: Boolean = false,
    val sources: NewsView? = null
) {
    object InProgress : NewsState(true, null)

    data class Error(val error: ErrorUi) : NewsState()

    data class Success(private val result: NewsView?) : NewsState(false, result)

    class Idle : NewsState(false, null)
}