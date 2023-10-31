package com.nazartaraniuk.natifetest.data

import com.nazartaraniuk.natifetest.data.exceptions.ApiErrorException
import retrofit2.HttpException
import java.io.IOException

inline fun <R> handleCatching(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: HttpException) {
        Result.failure(ApiErrorException("Error ${e.code()}"))
    } catch (e: IOException) {
        Result.failure(ApiErrorException("You don't have internet connection"))
    }
}