package com.ajijul.ny.di.builder

import android.app.Application
import com.ajijul.ny.MainActivity
import com.ajijul.ny.base.NyApplicationClass
import com.ajijul.ny.news_feed.module.NewsFeedModule
import com.ajijul.ny.news_feed.view.NewsFeedListFragmentView
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.Binds



/*We map all our views here. And Dagger know our
  views in compile time.*/

@Module
abstract class  ActivityBuilder {
    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity


    @Binds
    abstract fun bindApplication(app: NyApplicationClass): Application
}