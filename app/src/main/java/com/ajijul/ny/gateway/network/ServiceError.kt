package com.ajijul.ny.gateway.network

import okhttp3.ResponseBody

enum class ServiceError private constructor() {

    NO_INTERNET_CONNECTION {

        override val value: ResponseBody
            get() = responseBody

        override fun setValue(value: ResponseBody): ServiceError {
            this.responseBody = value

            return NO_INTERNET_CONNECTION
        }
    },
    SESSION_EXPIRED {

        override val value: ResponseBody
            get() = responseBody

        override fun setValue(value: ResponseBody): ServiceError {
            this.responseBody = value
            return SESSION_EXPIRED
        }
    },
    UNKNOWN_ERROR {

        override val value: ResponseBody
            get() = responseBody

        override fun setValue(value: ResponseBody): ServiceError {
            this.responseBody = value
            return UNKNOWN_ERROR
        }
    },
    TIME_OUT {

        override val value: ResponseBody
            get() = responseBody

        override fun setValue(value: ResponseBody): ServiceError {
            this.responseBody = value
            return TIME_OUT
        }
    },
    OTHER {

        override val value: ResponseBody
            get() = responseBody

        override fun setValue(value: ResponseBody): ServiceError {
            this.responseBody = value
            return OTHER
        }
    };

    internal lateinit var responseBody: ResponseBody
    abstract val value: ResponseBody

    abstract fun setValue(value: ResponseBody): ServiceError
}
