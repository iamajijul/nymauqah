package com.ajijul.ny.news_feed.news_details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import com.ajijul.ny.R
import com.ajijul.ny.base.BaseFragment
import com.ajijul.ny.databinding.NewsFeedDetailsBinding
import android.R.attr.data
import com.ajijul.ny.news_feed.model.Result
import com.ajijul.ny.news_feed.news_details.viewModel.NewsFeedsDetailsViewModel


class NewsDetailsFragmentView : BaseFragment() {

    private var binding: NewsFeedDetailsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = inflate(inflater, R.layout.news_feed_details, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.model = NewsFeedsDetailsViewModel(result)
    }


    companion object {
        var result: Result? = null
        fun newInstance(result: Result?): NewsDetailsFragmentView {
            this.result = result
            return NewsDetailsFragmentView()
        }
    }
}