package com.plcoding.cryptotracker.core.data.networking

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse


suspend  inline fun<reified T> responseToResults(
    response: HttpResponse
): Result<T, NetworkError> {
    return when(response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.Error(NetworkError.SERIALIZATION)
            }
        }
        400 -> Result.Error(NetworkError.BAD_REQUEST)
        401 -> Result.Error(NetworkError.UNAUTHENTICATED)
        403 -> Result.Error(NetworkError.UNAUTHORIZED)
        404 -> Result.Error(NetworkError.NOT_FOUND)
        408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
        422 -> Result.Error(NetworkError.UNPROCESSABLE_ENTITY) // TODO: Handle the server validation errors
        429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
        else -> Result.Error(NetworkError.UNKNOWN)
    }
}