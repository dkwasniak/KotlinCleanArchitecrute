package com.nomtek.domain.di

import rx.Scheduler

interface SchedulersProvider {

    fun computationSchaduler() : Scheduler

    fun mainThreadSchaduler() : Scheduler
}