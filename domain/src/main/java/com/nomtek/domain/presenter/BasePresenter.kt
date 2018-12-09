package com.nomtek.domain.presenter

import com.nomtek.domain.di.SchedulersProvider
import com.nomtek.domain.view.BaseView
import rx.Observable

open class BasePresenter<T : BaseView> {

    var view: T? = null

    open fun attach(view: T) {
        this.view = view
    }

    open fun detach() {
        this.view = null
    }
}

fun <T : Any> Observable<T>.applySchedulers(schedulersProvider: SchedulersProvider?): Observable<T> {
    return if (schedulersProvider == null) {
        this
    } else {
        this.subscribeOn(schedulersProvider.computationSchaduler())
            .observeOn(schedulersProvider.mainThreadSchaduler())
    }
}