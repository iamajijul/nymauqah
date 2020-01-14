package com.ajijul.ny.di.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.ny.AppUtils.Companion.convertDate
import com.ajijul.ny.news_feed.adapter.FeedListRecyclerAdapter
import com.ajijul.ny.news_feed.model.Result
import com.bumptech.glide.Glide

@DataBindingScope
class CustomViewBinding {

    @BindingAdapter("template")
    fun bindTemplate(imageView: ImageView, model: Result?) {
        Glide.with(imageView.context).load(model?.media?.get(0)?.mediaMetadata?.get(2)?.url)
            .into(imageView)
    }

    @BindingAdapter("newsDate")
    fun bindDate(textView: TextView, model: Result?) {
        textView.text = convertDate("yyyy-MM-dd","dd MMM, yyyy",model?.publishedDate)
    }
    @BindingAdapter("adapter", "data")
    fun bindRecyclerAdapter(
        recyclerView: RecyclerView,
        adapter: FeedListRecyclerAdapter?,
        data: LiveData<ArrayList<Result>>?
    ) {
        recyclerView.setAdapter(adapter)
        adapter?.notifyAdapter(data?.value ?: ArrayList())
    }
}