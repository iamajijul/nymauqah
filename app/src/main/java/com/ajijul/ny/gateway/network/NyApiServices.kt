package com.ajijul.ny.gateway.network


import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel

abstract class NyApiServices {


    abstract fun getFeeds(response: ServiceResponse<NyNewsFeedBaseModel>, period: String, apiKey: String)


}
