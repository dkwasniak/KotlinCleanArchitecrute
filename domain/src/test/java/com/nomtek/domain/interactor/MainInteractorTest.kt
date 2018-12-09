package com.nomtek.domain.interactor

import com.nomtek.domain.api.model.PostApiModel
import com.nomtek.domain.mapper.PostApiModelToViewModelMapper
import com.nomtek.domain.model.PostViewModel
import com.nomtek.domain.repository.MainRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import rx.Observable
import rx.observers.TestSubscriber
import kotlin.test.assertEquals

class MainInteractorTest {

    lateinit var target: MainInteractor

    @Mock
    lateinit var mainRepository: MainRepository

    @Mock
    lateinit var mapper: PostApiModelToViewModelMapper

    var mainTestSubscriber = TestSubscriber<List<PostViewModel>>()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        target = MainInteractor(mainRepository, mapper)
    }

    @Test
    fun testPositiveCase() {
        //given
        val result: List<PostApiModel> = listOf(PostApiModel())
        val mappedResult = PostViewModel()
        `when`(mainRepository.getPosts()).thenReturn(Observable.just(result))
        `when`(mapper.mapPostApiModelToViewModel(result[0])).thenReturn(mappedResult)

        //when
        target.getPosts().subscribe(mainTestSubscriber)

        //then
        mainTestSubscriber.assertNoErrors()
        assertEquals(mainTestSubscriber.onNextEvents[0][0], mappedResult)
        mainTestSubscriber.assertCompleted()

    }

    @Test
    fun testNegativeCase() {
        //given
        val error = Exception()
        `when`(mainRepository.getPosts()).thenReturn(Observable.error(error))

        //when
        target.getPosts().subscribe(mainTestSubscriber)

        //then
        mainTestSubscriber.assertError(error)
        mainTestSubscriber.assertNotCompleted()
    }

}