package com.ajijul.ny.gateway.network


interface ServiceResponse<Object> {
    fun onSuccess(responseObject: Object)
    fun onError(error: ServiceError)
}
