package com.nomtek.domain.repository

import com.nomtek.domain.api.model.PostApiModel
import rx.Observable

interface MainRepository {

    fun getPosts(): Observable<List<PostApiModel>>
}