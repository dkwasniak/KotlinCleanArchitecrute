package com.nomtek.interview.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.nomtek.domain.model.PostViewModel
import com.nomtek.domain.presenter.MainViewPresenter
import com.nomtek.domain.view.MainView
import com.nomtek.interview.R
import com.nomtek.interview.applicationComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        applicationComponent.inject(this)
        presenter.getPosts()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        presenter.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detach()
    }

    override fun loadData(it: List<PostViewModel>?) {
        Log.d("LOAD DATA COMPLETE", it.toString())
    }

    override fun showError(it: Throwable) {
        Log.d("ERROR", it.printStackTrace().toString())
    }
}
