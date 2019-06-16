package com.ajijul.ny.gateway.network

import android.content.Context
import android.util.Log
import com.ajijul.ny.gateway.HttpClient
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NyServiceClient() : NyApiServices() {


    override fun getFeeds(response: ServiceResponse<NyNewsFeedBaseModel>, period: String, apiKey: String) {
        val apiEndPointPG = HttpClient.getHttpClient()
        val call = apiEndPointPG.getFeeds(period, apiKey)
        call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<NyNewsFeedBaseModel> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("ee","OnError");

                }

                override fun onNext(list: NyNewsFeedBaseModel) {
                      Log.d("ee",""+list.results?.size!!);
                      response.onSuccess(list)
                    // allCurrencyList = new ArrayList<>(coinList.getData().values());
                }

                override fun onError(e: Throwable) {
                   response.onError(ServiceError.UNKNOWN_ERROR)
                }

                override fun onComplete() {
                    // Updates UI with data
                    // cPresenter.updateCoinList(allCurrencyList);
                }
            })
    }
}
