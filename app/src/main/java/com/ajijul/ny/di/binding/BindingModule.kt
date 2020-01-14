package com.ajijul.ny.di.binding

import dagger.Module
import dagger.Provides

@Module
class BindingModule {

    @Provides
    @DataBindingScope
    fun provideCustomViewDataBinding(): CustomViewBinding {
        return CustomViewBinding()
    }

}