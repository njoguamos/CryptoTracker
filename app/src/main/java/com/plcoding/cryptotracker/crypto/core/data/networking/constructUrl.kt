package com.plcoding.cryptotracker.crypto.core.data.networking

import com.plcoding.cryptotracker.BuildConfig

fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(n =1)
        else -> BuildConfig.BASE_URL + url
    }
}