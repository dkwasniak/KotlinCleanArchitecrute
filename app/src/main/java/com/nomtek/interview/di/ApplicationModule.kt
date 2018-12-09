package com.nomtek.interview.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nomtek.domain.di.SchedulersProvider
import dagger.Module
import dagger.Provides
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Singleton

@Module
class ApplicationModule(context: Context) {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideSchedulers(): SchedulersProvider {
        return object : SchedulersProvider {
            override fun computationSchaduler(): Scheduler {
                return Schedulers.io()
            }

            override fun mainThreadSchaduler(): Scheduler {
                return AndroidSchedulers.mainThread()
            }

        }
    }

}