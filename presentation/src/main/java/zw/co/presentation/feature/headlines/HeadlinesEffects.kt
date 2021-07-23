package zw.co.presentation.feature.headlines

import zw.co.presentation.base.UiEffect

sealed class HeadlinesEffects: UiEffect {
    object ShowHeadlines: HeadlinesEffects()
    object ShowHeadlinesByCategory: HeadlinesEffects()
}