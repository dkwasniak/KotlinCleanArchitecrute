package com.nomtek.domain.view

import com.nomtek.domain.model.PostViewModel

interface MainView: BaseView {

    fun loadData(it: List<PostViewModel>?)

    fun showError(it: Throwable)
}