package com.nomtek.domain.presenter

import com.nhaarman.mockito_kotlin.verify
import com.nomtek.domain.interactor.MainInteractor
import com.nomtek.domain.view.MainView
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.never
import org.mockito.MockitoAnnotations
import org.mockito.internal.verification.Times
import rx.Observable


class MainViewPresenterTest {

    private lateinit var target: MainViewPresenter

    @Mock
    lateinit var mainInteractor: MainInteractor

    @Mock
    lateinit var view: MainView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        target = MainViewPresenter(mainInteractor)
        target.attach(view)

    }

    @Test
    fun checkIfPostsAreSetOnSuccessResult() {
        //given
        `when`(mainInteractor.getPosts()).thenReturn(Observable.just(ArrayList()))

        //when
        target.getPosts()

        //then
        verify(view).loadData(ArgumentMatchers.anyList())
        verify(view, Times(1)).loadData(ArgumentMatchers.anyList())
    }

    @Test
    fun checkIfErrorIsShownWhenInteractorFails() {
        //given
        val exception = Exception()
        `when`(mainInteractor.getPosts()).thenReturn(Observable.error(exception))

        //when
        target.getPosts()

        //then
        verify(view, Times(1)).showError(exception)
        verify(view, never()).loadData(ArgumentMatchers.anyList())
    }
}
