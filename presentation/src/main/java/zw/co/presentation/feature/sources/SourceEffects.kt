package zw.co.presentation.feature.sources

import zw.co.presentation.base.UiEffect

sealed class SourceEffects: UiEffect {
    object ShowSources: SourceEffects()
}