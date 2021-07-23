package zw.co.presentation.error

sealed class ErrorUi {

    object Network : ErrorUi()

    object NotFound : ErrorUi()

    object AccessDenied : ErrorUi()

    object ServiceUnavailable : ErrorUi()

    object Unknown : ErrorUi()

    object NetworkUnavailable: ErrorUi()
}