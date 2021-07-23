package zw.co.presentation.feature.headlines

import zw.co.presentation.base.UiIntent

sealed class HeadlinesIntent: UiIntent {
    object LoadHeadlines: HeadlinesIntent()
    data class LoadHeadLinesByCategory(val category: String): HeadlinesIntent()
}