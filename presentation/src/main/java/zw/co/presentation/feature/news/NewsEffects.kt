package zw.co.presentation.feature.news

import zw.co.presentation.base.UiEffect

sealed class NewsEffects : UiEffect {
    object ShowNews : NewsEffects()
}
