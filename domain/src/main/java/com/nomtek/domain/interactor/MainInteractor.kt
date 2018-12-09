package com.nomtek.domain.interactor

import com.nomtek.domain.mapper.PostApiModelToViewModelMapper
import com.nomtek.domain.model.PostViewModel
import com.nomtek.domain.repository.MainRepository
import rx.Observable
import javax.inject.Inject

open class MainInteractor @Inject constructor(
    private val mainRepository: MainRepository,
    private val mapper: PostApiModelToViewModelMapper
) {

    open fun getPosts(): Observable<List<PostViewModel>> {
        return mainRepository.getPosts().map {
            it.map {
                mapper.mapPostApiModelToViewModel(it)
            }
        }
    }
}