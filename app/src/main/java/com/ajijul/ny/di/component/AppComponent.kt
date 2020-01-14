package com.ajijul.ny.di.component

import com.ajijul.ny.base.NyApplicationClass
import com.ajijul.ny.di.builder.ActivityBuilder
import com.ajijul.ny.di.builder.FragmentBuilder
import com.ajijul.ny.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    ActivityBuilder::class,
    FragmentBuilder::class])
interface AppComponent : AndroidInjector<NyApplicationClass> {
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: Application): Builder
//
//        fun build(): AppComponent
//    }
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<NyApplicationClass>()
}