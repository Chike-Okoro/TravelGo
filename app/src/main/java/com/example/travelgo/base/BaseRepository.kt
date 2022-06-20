package com.example.travelgo.base

import com.example.travelgo.utils.UseCaseResult
import kotlinx.coroutines.Deferred
import timber.log.Timber

open class BaseRepository {
    suspend fun <T:Any> safeGetApiCall
                (apiCall: () -> Deferred<T>,
                 checkIfSuccessful:(T)->Boolean,
                 onSuccessOperations: (suspend (response:T)->Unit)? = null
    ): UseCaseResult<T> {

        return try {
            val response = apiCall().await()
            if (checkIfSuccessful(response)) {
                if (onSuccessOperations != null) {
                    try {
                        onSuccessOperations(response)
                    } catch (ex: Exception) {
                        Timber.e(ex)
                    }
                }
                UseCaseResult.Success(response)
            } else {
                UseCaseResult.FailedAPI(response)
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            UseCaseResult.Error(ex)
        }
    }

    suspend fun <R : Any, T : Any> safeApiCall(
        request: R,
        apiCall: (request: R) -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean
    ): UseCaseResult<T> {
        return try {
            val response = apiCall(request).await()
            if (checkIfSuccessful(response)) {
                UseCaseResult.Success(response)
            } else {
                UseCaseResult.FailedAPI(response)
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            UseCaseResult.Error(ex)
        }
    }

    suspend fun <R : Any, T : Any> safeApiCallAndNormalOperation(
        request: R,
        apiCall: (request: R) -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean,
        onSuccessOperations: (response: T) -> Unit
    ): UseCaseResult<T> {
        return try {
            val response = apiCall(request).await()
            if (checkIfSuccessful(response)) {
                try {
                    onSuccessOperations(response)
                } catch (ex: Exception) {
                    Timber.e(ex)
                }
                UseCaseResult.Success(response)
            } else {
                UseCaseResult.FailedAPI(response)
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            UseCaseResult.Error(ex)
        }
    }

    suspend fun <R : Any, T : Any> safeApiCall(
        request: R,
        apiCall: (request: R) -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean,
        onSuccessOperations: (response: T) -> Unit
    ): UseCaseResult<T> {
        return try {
            val response = apiCall(request).await()
            if (checkIfSuccessful(response)) {
                try {
                    onSuccessOperations(response)
                } catch (ex: Exception) {
                    Timber.e(ex)
                }
                UseCaseResult.Success(response)
            } else {
                UseCaseResult.FailedAPI(response)
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            UseCaseResult.Error(ex)
        }
    }

    suspend fun <R : Any, T : Any> safeApiCall(
        request: R,
        apiCall: (request: R) -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean,
        onSuccessOperations: suspend (response: T) -> Unit
    ): UseCaseResult<T> {
        return try {
            val response = apiCall(request).await()
            if (checkIfSuccessful(response)) {
                try {
                    onSuccessOperations(response)
                } catch (ex: Exception) {
                    Timber.e(ex)
                }
                UseCaseResult.Success(response)
            } else {
                UseCaseResult.FailedAPI(response)
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            UseCaseResult.Error(ex)
        }
    }

    suspend fun <R : Any, T : Any> safeApiCall(
        request: R,
        apiCall: (request: R) -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean,
        onSuccessOperations: suspend (request: R, response: T) -> Unit
    ): UseCaseResult<T> {
        return try {
            val response = apiCall(request).await()
            if (checkIfSuccessful(response)) {
                try {
                    onSuccessOperations(request, response)
                } catch (ex: Exception) {
                    Timber.e(ex)
                }
                UseCaseResult.Success(response)
            } else {
                UseCaseResult.FailedAPI(response)
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            UseCaseResult.Error(ex)
        }
    }

    suspend fun <R : Any, T : Any> safeWorkerApiCall(
        request: R,
        apiCall: (request: R) -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean
    ): Boolean {
        return try {
            val response = apiCall(request).await()
            checkIfSuccessful(response)
        } catch (ex: Exception) {
            Timber.e(ex)
            false
        }
    }

    suspend fun <R : Any, T : Any> safeWorkerApiCall(
        request: R,
        apiCall: (request: R) -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean,
        onSuccessOperations: (response: T) -> Unit
    ): Boolean {
        return try {
            val response = apiCall(request).await()
            if (checkIfSuccessful(response)) {
                onSuccessOperations(response)
                true
            } else {
                false
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            false
        }
    }
    suspend fun < T : Any> safeWorkerApiCallGet(
        apiCall: () -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean,
        onSuccessOperations: (response: T) -> Unit
    ): Boolean {
        return try {
            val response = apiCall().await()
            if (checkIfSuccessful(response)) {
                onSuccessOperations(response)
                true
            } else {
                false
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            false
        }
    }
    suspend fun < T : Any> safeWorkerApiCallGet(
        apiCall: () -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean,
        onSuccessOperations: suspend (response: T) -> Unit
    ): Boolean {
        return try {
            val response = apiCall().await()
            if (checkIfSuccessful(response)) {
                onSuccessOperations(response)
                true
            } else {
                false
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            false
        }
    }

    suspend fun <R : Any, T : Any> safeWorkerApiCall(
        request: R,
        apiCall: (request: R) -> Deferred<T>,
        checkIfSuccessful: (T) -> Boolean,
        onSuccessOperations: suspend (response: T) -> Unit
    ): Boolean {
        return try {
            val response = apiCall(request).await()
            if (checkIfSuccessful(response)) {
                try {
                    onSuccessOperations(response)
                } catch (ex: java.lang.Exception) {
                    Timber.e(ex)
                }

                true
            } else {
                false
            }
        } catch (ex: Exception) {
            Timber.e(ex)
            false
        }
    }
}