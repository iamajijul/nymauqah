package com.ajijul.ny.di.binding

import androidx.databinding.DataBindingComponent
import com.ajijul.ny.di.component.AppComponent
import dagger.Component

@DataBindingScope
@Component(dependencies = [AppComponent::class], modules = [BindingModule::class])
interface BindingComponent : DataBindingComponent{
    override fun getCustomViewBinding(): CustomViewBinding {
        return CustomViewBinding()
    }
}