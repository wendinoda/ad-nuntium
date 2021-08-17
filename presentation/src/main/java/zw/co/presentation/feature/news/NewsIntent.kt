package zw.co.presentation.feature.news

import zw.co.presentation.base.UiIntent

sealed class NewsIntent : UiIntent {
    object LoadNews: NewsIntent()
}
