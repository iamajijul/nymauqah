package com.ajijul.ny.gateway

import android.content.Context
import com.ajijul.ny.gateway.network.NyApiEndPoint
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

class HttpClient {
    companion object {
        var okHttpClientReach: OkHttpClient.Builder? = null
        var okHttpClientGCC: OkHttpClient.Builder? = null

        private val BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/"

        private fun httpClientBuilder(): OkHttpClient {
            val okHttpClient = OkHttpClient.Builder()
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient.writeTimeout(120, TimeUnit.SECONDS)
            okHttpClient.readTimeout(120, TimeUnit.SECONDS)
            okHttpClient.addInterceptor(logging)
            //okHttpClient.interceptors().add(new BasicAuthInterceptor("MShipAdmin", "Msh!p@dm!n*auth$"));
            return okHttpClient.build()
        }


        fun getHttpClient(): NyApiEndPoint {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClientBuilder())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(NyApiEndPoint::class.java)
        }
    }
}