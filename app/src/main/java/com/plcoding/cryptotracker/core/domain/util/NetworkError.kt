package com.plcoding.cryptotracker.core.domain.util


enum class NetworkError: Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER_ERROR,
    SERIALIZATION,
    UNAUTHENTICATED,
    UNAUTHORIZED,
    NOT_FOUND,
    BAD_REQUEST,
    UNPROCESSABLE_ENTITY,
    UNKNOWN,
}