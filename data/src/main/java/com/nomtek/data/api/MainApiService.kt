package com.nomtek.data.api

import com.nomtek.domain.api.model.PostApiModel
import retrofit2.Response
import retrofit2.http.GET
import rx.Observable

interface MainApiService {

    @GET("/posts")
    fun getPosts() : Observable<Response<List<PostApiModel>>>
}