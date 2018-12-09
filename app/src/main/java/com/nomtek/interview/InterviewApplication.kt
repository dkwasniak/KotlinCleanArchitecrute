package com.nomtek.interview

import android.app.Application
import com.nomtek.data.di.ApiModule
import com.nomtek.interview.di.ApplicationComponent
import com.nomtek.interview.di.ApplicationModule
import com.nomtek.interview.di.DaggerApplicationComponent

class InterviewApplication : Application() {

    companion object {
        lateinit var instance: InterviewApplication
            private set
    }

    val applicationComponent: ApplicationComponent =
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .apiModule(ApiModule(BuildConfig.SERVER_URL)).build()


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

val applicationComponent: ApplicationComponent
    get() {
        return InterviewApplication.instance.applicationComponent
    }

