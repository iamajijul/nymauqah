package com.ajijul.ny.di.module

import android.app.Application
import android.content.Context
import com.ajijul.ny.gateway.network.NyServiceClient
import dagger.Module
import javax.inject.Singleton
import dagger.Provides


/*
* We provide retrofit, okhttp, persistence db, shared pref etc here.
* There is an important detail here.
*  We have to add our subcomponents to ApplicationModule.
*  So our dagger graph will undestand that..*/

@Module
class ApplicationModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideServiceClient(): NyServiceClient {
        return NyServiceClient()
    }


}