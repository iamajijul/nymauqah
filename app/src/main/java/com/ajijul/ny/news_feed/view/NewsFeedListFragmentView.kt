package com.ajijul.ny.news_feed.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ajijul.ny.base.BaseFragment
import androidx.lifecycle.ViewModelProviders
import com.ajijul.ny.R
import com.ajijul.ny.news_feed.viewModel.NewsFeedsViewModel
import com.ajijul.ny.news_feed.adapter.FeedListRecyclerAdapter
import com.ajijul.ny.news_feed.model.NyNewsFeedBaseModel
import com.ajijul.ny.news_feed.model.Result
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajijul.ny.MainActivity
import com.ajijul.ny.news_feed.adapter.interfaces.SetOnNewsClickListener
import com.ajijul.ny.news_feed.news_details.view.NewsDetailsFragmentView
import kotlinx.android.synthetic.main.news_feed_list_fragment.*


class NewsFeedListFragmentView : BaseFragment(), SetOnNewsClickListener {
    override fun onItemClick(result: Result) {
        (activity as MainActivity).fragmentTransaction(NewsDetailsFragmentView.newInstance(result),"Details")
    }

    var articleArrayList: ArrayList<Result> = ArrayList()
    var newsAdapter: FeedListRecyclerAdapter? = null
    var newsViewModel: NewsFeedsViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.news_feed_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel = ViewModelProviders.of(this).get(NewsFeedsViewModel::class.java)
        newsViewModel?.init()
        newsViewModel?.getNewsRepository()?.observe(this,
            Observer<NyNewsFeedBaseModel> {
                nyNewsFeedList_progress.visibility = View.GONE
                if (it != null)
                    newsAdapter?.notifyAdapter(it.results)
            })
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = FeedListRecyclerAdapter(context, articleArrayList, this)
            nyNewsFeedList_rv.adapter = newsAdapter
        } else {
            newsAdapter?.notifyDataSetChanged()
        }
    }

}