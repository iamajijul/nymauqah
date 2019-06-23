package com.ajijul.ny.news_feed.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import androidx.lifecycle.LiveData
import com.ajijul.ny.news_feed.repository.NewFeedsRepository

class NewsFeedsViewModel : ViewModel() {

    var newsFeedLiveData : MutableLiveData<NyNewsFeedBaseModel>? = null
    private var newsRepository: NewFeedsRepository? = null

    fun init() {
        if (newsFeedLiveData != null) {
            return
        }
        newsRepository = NewFeedsRepository.getInstance()
        newsFeedLiveData = newsRepository!!.getNews("7", "oxMIIzfKMZoGGlMhQ1ENH4MAqFXarpct")

    }

    fun getNewsRepository(): MutableLiveData<NyNewsFeedBaseModel>? {
        return newsFeedLiveData
    }
}