package com.ajijul.ny.news_feed.viewModel

import android.os.Build.VERSION_CODES.M
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.ajijul.ny.news_feed.adapter.FeedListRecyclerAdapter
import com.ajijul.ny.news_feed.model.Result
import com.ajijul.ny.news_feed.repository.NewFeedsRepository
import javax.inject.Inject

class NewsFeedsViewModel @Inject constructor( var newsRepository: NewFeedsRepository) : ViewModel() {

    var _newsFeedLiveData : MediatorLiveData<NyNewsFeedBaseModel> = MediatorLiveData()
    private  var listOfNews:MutableLiveData<ArrayList<Result>> = MutableLiveData()
    private  var showProgress:MutableLiveData<Boolean> = MutableLiveData()
    private var showDetails = MutableLiveData<Result>()

    var adapter : FeedListRecyclerAdapter

    init {
        adapter = FeedListRecyclerAdapter(this)
        showProgress.value = true
        val newsFeedLiveData = newsRepository.getNews("7", "oxMIIzfKMZoGGlMhQ1ENH4MAqFXarpct")
        _newsFeedLiveData.addSource<NyNewsFeedBaseModel>(newsFeedLiveData) { exercisList ->
            listOfNews.value = exercisList?.results as ArrayList<Result>?
            showProgress.value = false

        }
    }

    fun getData(): MutableLiveData<ArrayList<Result>> {
        return listOfNews
    }

    fun getNewsRepository(): MutableLiveData<NyNewsFeedBaseModel>? {
        return _newsFeedLiveData
    }
    fun onItemClick(pos : Int) {
        showDetails.value = listOfNews.value?.get(pos)
    }
    fun getShowDetailsData(): MutableLiveData<Result> {

        return showDetails

    }
    fun getShowProgress(): MutableLiveData<Boolean> {

        return showProgress

    }
}