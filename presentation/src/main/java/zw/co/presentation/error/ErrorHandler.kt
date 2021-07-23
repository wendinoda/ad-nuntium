package zw.co.presentation.error

import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import java.net.SocketException
import javax.inject.Inject

class ErrorHandler @Inject constructor() {
    fun getError(throwable: Throwable): ErrorUi {
        return when(throwable) {
            is IOException -> ErrorUi.Network
            is SocketException -> ErrorUi.NetworkUnavailable
            is HttpException -> {
                when(throwable.code()) {
                    // not found
                    HttpURLConnection.HTTP_NOT_FOUND -> ErrorUi.NotFound

                    // access denied
                    HttpURLConnection.HTTP_FORBIDDEN -> ErrorUi.AccessDenied

                    // unavailable service
                    HttpURLConnection.HTTP_UNAVAILABLE -> ErrorUi.ServiceUnavailable

                    // all the others will be treated as unknown error
                    else -> ErrorUi.Unknown
                }
            }
            else -> ErrorUi.Unknown
        }
    }
}