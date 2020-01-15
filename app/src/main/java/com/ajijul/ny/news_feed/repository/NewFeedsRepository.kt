package com.ajijul.ny.news_feed.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ajijul.ny.gateway.HttpClient
import com.ajijul.ny.gateway.network.NyServiceClient
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class NewFeedsRepository @Inject constructor(var newsApi: NyServiceClient?) {


    fun authenticateBlocking(): NyNewsFeedBaseModel? {
        val apiEndPointPG = HttpClient.getHttpClient()
        return apiEndPointPG.getFeeds("7", "oxMIIzfKMZoGGlMhQ1ENH4MAqFXarpct").blockingSingle()
    }


    fun getNews(period: String, apiKey: String): MutableLiveData<NyNewsFeedBaseModel> {
        val newsData = MutableLiveData<NyNewsFeedBaseModel>()
        newsApi?.getFeeds(period, apiKey)!!.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<NyNewsFeedBaseModel> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("ee", "OnError");

                }

                override fun onNext(list: NyNewsFeedBaseModel) {
                    Log.d("ee", "" + list.results?.size!!);
                    newsData.value = list
                }

                override fun onError(e: Throwable) {
                    newsData.value = null
                }

                override fun onComplete() {
                }
            })

        return newsData
    }
}