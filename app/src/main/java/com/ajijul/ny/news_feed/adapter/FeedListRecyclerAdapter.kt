package com.ajijul.ny.news_feed.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.ny.R
import com.ajijul.ny.news_feed.adapter.interfaces.SetOnNewsClickListener
import com.ajijul.ny.news_feed.adapter.viewHolder.NewsFeedViewHolder
import com.ajijul.ny.news_feed.model.Result

class FeedListRecyclerAdapter(
    private val mContext: Context?,
    private var newsFeeds: List<Result>?,
    private val listener: SetOnNewsClickListener?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var recyclerView: RecyclerView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        viewHolder =
            NewsFeedViewHolder(LayoutInflater.from(mContext).inflate(R.layout.news_feed_list_row, parent, false))
        return viewHolder

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = newsFeeds!![position]
        (holder as NewsFeedViewHolder).setData(listener, model)

    }

    fun notifyAdapter(newsFeed: List<Result>?) {
        this.newsFeeds = newsFeed
        notifyDataSetChanged()
        recyclerView?.scheduleLayoutAnimation()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }


    override fun getItemCount(): Int {
        return newsFeeds?.size!!
    }


}




