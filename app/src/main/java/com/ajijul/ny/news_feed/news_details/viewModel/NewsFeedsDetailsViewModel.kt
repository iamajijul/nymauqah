package com.ajijul.ny.news_feed.news_details.viewModel

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import androidx.lifecycle.LiveData
import com.ajijul.ny.AppUtils
import com.ajijul.ny.news_feed.model.Result
import com.ajijul.ny.news_feed.repository.NewFeedsRepository
import com.bumptech.glide.Glide


class NewsFeedsDetailsViewModel : ViewModel {
    var newsResultModel: Result? = null

    constructor(newsResultModel: Result?) {
        this.newsResultModel = newsResultModel
    }

    fun setNewsModel(newsResultModel: Result) {
        this.newsResultModel = newsResultModel
    }

    companion object {

        @JvmStatic
        @BindingAdapter("formatDate")
        fun formatDate(view: TextView, date: String?) {
            view.text = AppUtils.convertDate("yyyy-MM-dd", "dd MMM, yyyy", date)

        }

        @JvmStatic
        @BindingAdapter("setBanner")
        fun setBanner(view: ImageView, result: Result?) {
            Glide.with(view?.context!!).load(result?.media!![0].mediaMetadata!![2].url!!)
                .into(view)
        }

        @JvmStatic
        @BindingAdapter("setDetails")
        fun setDetails(view: TextView, result: Result?) {
            view.text = result?.media!![0].caption

        }

    }

}