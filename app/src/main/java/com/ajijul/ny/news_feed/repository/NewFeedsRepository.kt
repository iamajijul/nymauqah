package com.ajijul.ny.news_feed.repository

import androidx.lifecycle.MutableLiveData
import com.ajijul.ny.gateway.HttpClient
import com.ajijul.ny.gateway.network.NyServiceClient
import com.ajijul.ny.gateway.network.ServiceError
import com.ajijul.ny.gateway.network.ServiceResponse
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel


class NewFeedsRepository {


    companion object {
        private var newsRepository: NewFeedsRepository? = null
        private var newsApi: NyServiceClient? = null
        fun getInstance(): NewFeedsRepository? {
            if (newsRepository == null) {
                newsRepository = init()
            }
            return newsRepository
        }
        fun init(): NewFeedsRepository? {
            newsApi = NyServiceClient()
            return NewFeedsRepository()
        }
    }
    fun authenticateBlocking(): NyNewsFeedBaseModel?{
        val apiEndPointPG = HttpClient.getHttpClient()
        return apiEndPointPG.getFeeds("7","oxMIIzfKMZoGGlMhQ1ENH4MAqFXarpct").blockingSingle()
    }


    fun getNews(period: String, apiKey: String): MutableLiveData<NyNewsFeedBaseModel> {
        val newsData = MutableLiveData<NyNewsFeedBaseModel>()
        newsApi?.getFeeds(object : ServiceResponse<NyNewsFeedBaseModel> {
            override fun onSuccess(responseObject: NyNewsFeedBaseModel) {
                newsData.value = responseObject
            }

            override fun onError(error: ServiceError) {
                newsData.value = null
            }

        }, period, apiKey)

        return newsData
    }
}