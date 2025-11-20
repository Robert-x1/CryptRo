package com.robert.cryptro.core.data.networking

import com.robert.cryptro.core.domain.utils.NetworkError
import com.robert.cryptro.core.domain.utils.Result

import kotlinx.coroutines.ensureActive
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeApiCall(
    crossinline execute: suspend () -> T
): Result<T, NetworkError> {
    return try {
        coroutineContext.ensureActive()
        val response = execute()
        Result.Success(response)
    } catch (e: HttpException) {
        coroutineContext.ensureActive()
        when (e.code()) {
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOW)
        }
    } catch (e: IOException) {

        coroutineContext.ensureActive()
        Result.Error(NetworkError.NO_INTERNET)
    } catch (e: SerializationException) {

        coroutineContext.ensureActive()
        Result.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        Result.Error(NetworkError.UNKNOW)
    }
}