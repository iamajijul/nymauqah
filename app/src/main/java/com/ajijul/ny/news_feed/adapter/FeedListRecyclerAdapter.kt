package com.ajijul.ny.news_feed.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.ny.R
import com.ajijul.ny.news_feed.adapter.viewHolder.NewsFeedViewHolder
import com.ajijul.ny.news_feed.model.Result
import com.ajijul.ny.news_feed.viewModel.NewsFeedsViewModel
import javax.inject.Inject

class FeedListRecyclerAdapter @Inject constructor(var viewModel : NewsFeedsViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var newsFeeds: List<Result>
    init {
       newsFeeds = ArrayList()
    }
    private var recyclerView: RecyclerView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        viewHolder =
            NewsFeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_feed_list_row, parent, false))
        return viewHolder

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = newsFeeds[position]
        (holder as NewsFeedViewHolder).setData(viewModel, model,position)

    }

    fun notifyAdapter(newsFeed: List<Result>) {
        this.newsFeeds = newsFeed
        notifyDataSetChanged()
        recyclerView?.scheduleLayoutAnimation()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }
    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        if (holder is NewsFeedViewHolder)
            holder.bind()
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        if (holder is NewsFeedViewHolder)
            holder.unbind()
    }

    override fun getItemCount(): Int {
        return newsFeeds.size
    }


}




