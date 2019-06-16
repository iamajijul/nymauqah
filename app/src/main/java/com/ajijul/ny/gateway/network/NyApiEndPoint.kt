package com.ajijul.ny.gateway.network

import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NyApiEndPoint {


    @GET("viewed/{period}.json")
    fun getFeeds(@Path("period") period: String, @Query("api-key") apiKey: String): Observable<NyNewsFeedBaseModel>
}