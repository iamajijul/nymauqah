package com.ajijul.ny.news_feed.module

import androidx.lifecycle.ViewModelProvider
import com.ajijul.ny.di.ViewModelProviderFactory
import com.ajijul.ny.gateway.network.NyServiceClient
import com.ajijul.ny.news_feed.adapter.FeedListRecyclerAdapter
import com.ajijul.ny.news_feed.repository.NewFeedsRepository
import com.ajijul.ny.news_feed.viewModel.NewsFeedsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class NewsFeedModule {

    @Provides
    fun provideNewsFeedViewModel(newFeedsRepository: NewFeedsRepository): NewsFeedsViewModel {
        return NewsFeedsViewModel(newFeedsRepository)
    }

    @Provides
    fun provideNewsFeedRepo(nyClient: NyServiceClient): NewFeedsRepository {
        return NewFeedsRepository(nyClient)
    }

    @Provides
    fun recyclerAdapter(viewModel: NewsFeedsViewModel): FeedListRecyclerAdapter {
        return FeedListRecyclerAdapter(viewModel)
    }

    @Provides
    fun provideLandingViewModelProvider(viewModel: NewsFeedsViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }
}