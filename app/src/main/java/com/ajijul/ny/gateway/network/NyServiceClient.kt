package com.ajijul.ny.gateway.network

import com.ajijul.ny.gateway.HttpClient
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import io.reactivex.Observable

class NyServiceClient : NyApiServices() {


    override fun getFeeds( period: String, apiKey: String) : Observable<NyNewsFeedBaseModel>{
        val apiEndPointPG = HttpClient.getHttpClient()
        return apiEndPointPG.getFeeds(period, apiKey)
    }
}
