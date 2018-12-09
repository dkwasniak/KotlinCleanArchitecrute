package com.nomtek.domain.presenter

import com.nomtek.domain.di.SchedulersProvider
import com.nomtek.domain.interactor.MainInteractor
import com.nomtek.domain.view.MainView
import rx.Observable
import rx.lang.kotlin.subscribeBy
import javax.inject.Inject

class MainViewPresenter @Inject constructor(
    private val mainInteractor: MainInteractor,
    private val schedulersProvider: SchedulersProvider? = null

) : BasePresenter<MainView>() {

    fun getPosts() {
        mainInteractor.getPosts()
            .applySchadulers(schedulersProvider)
            .subscribeBy(
                onNext = {
                    view?.loadData(it)
                },
                onError = {
                    view?.showError(it)
                }
            )
    }

    fun <T : Any> Observable<T>.applySchadulers(schedulersProvider: SchedulersProvider?): Observable<T> {
        return if (schedulersProvider == null) {
            this
        } else {
            this.subscribeOn(schedulersProvider.computationSchaduler())
                .observeOn(schedulersProvider.mainThreadSchaduler())
        }
    }
}