package com.ajijul.ny.news_feed.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
import com.ajijul.ny.databinding.NewsFeedListFragmentBinding
import com.ajijul.ny.news_feed.adapter.interfaces.SetOnNewsClickListener
import com.ajijul.ny.news_feed.news_details.view.NewsDetailsFragmentView
import kotlinx.android.synthetic.main.news_feed_list_fragment.*
import javax.inject.Inject


class NewsFeedListFragmentView : BaseFragment() {
    //    override fun onItemClick(result: Result) {
//        (activity as MainActivity).fragmentTransaction(NewsDetailsFragmentView.newInstance(result),"Details")
//    }
    var newsViewModel: NewsFeedsViewModel? = null

    lateinit var binding: NewsFeedListFragmentBinding
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsViewModel = ViewModelProviders.of(this, viewModelProviderFactory)
            .get(NewsFeedsViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.news_feed_list_fragment, container, false
        )
        binding.myViewModel = newsViewModel
        binding.lifecycleOwner = this; // <-- this enables MutableLiveData to be update on your UI
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel?.getNewsRepository()?.observe(this,
            Observer {
            })
        newsViewModel?.getShowDetailsData()?.observe(this, Observer {
            (activity as MainActivity).fragmentTransaction(
                NewsDetailsFragmentView.newInstance(it),
                "Details"
            )

        })
        newsViewModel?.getShowProgress()?.observe(this, Observer {
            if (it)
                nyNewsFeedList_progress.visibility = View.VISIBLE
            else nyNewsFeedList_progress.visibility = View.GONE

        })
    }


}