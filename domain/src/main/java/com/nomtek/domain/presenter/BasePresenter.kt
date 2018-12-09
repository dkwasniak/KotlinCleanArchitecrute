package com.nomtek.domain.presenter

import com.nomtek.domain.view.BaseView

open class BasePresenter<T : BaseView> {

    var view: T? = null

    open fun attach(view: T) {
        this.view = view
    }

    open fun detach() {
        this.view = null
    }
}