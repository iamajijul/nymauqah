package com.ajijul.ny.gateway.network


import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import io.reactivex.Observable

abstract class NyApiServices {


    abstract fun getFeeds( period: String, apiKey: String): Observable<NyNewsFeedBaseModel>


}
