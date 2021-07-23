package zw.co.presentation.feature.sources

import zw.co.presentation.base.UiIntent

sealed class SourceIntent: UiIntent {
    object LoadSources: SourceIntent()
}