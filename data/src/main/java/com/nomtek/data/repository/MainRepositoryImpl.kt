package com.nomtek.data.repository

import android.accounts.NetworkErrorException
import com.nomtek.data.api.MainApiService
import com.nomtek.domain.api.model.PostApiModel
import com.nomtek.domain.repository.MainRepository
import rx.Observable

class MainRepositoryImpl(private val mainApiService: MainApiService) : MainRepository {

    override fun getPosts(): Observable<List<PostApiModel>> {
        return mainApiService.getPosts().flatMap {
            if(it.isSuccessful) {
                Observable.just(it.body())
            } else {
                Observable.error(NetworkErrorException())
            }
        }
    }
}