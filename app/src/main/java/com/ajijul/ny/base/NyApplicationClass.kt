package com.ajijul.ny.base

import androidx.databinding.DataBindingUtil
import com.ajijul.ny.di.binding.DaggerBindingComponent
import com.ajijul.ny.di.component.AppComponent
import com.ajijul.ny.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class NyApplicationClass : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        val appComponent = DaggerAppComponent.builder().create(this)

        val bindingComponent = DaggerBindingComponent.builder()
            .appComponent(appComponent as AppComponent?)
            .build()
        DataBindingUtil.setDefaultComponent(bindingComponent)
        return appComponent
    }
}