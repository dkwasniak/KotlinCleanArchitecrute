package com.nomtek.interview.di

import com.nomtek.data.di.ApiModule
import com.nomtek.data.di.DataModule
import com.nomtek.domain.di.DomainModule
import com.nomtek.interview.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DomainModule::class, ApiModule::class, DataModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}