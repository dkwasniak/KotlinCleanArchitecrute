package com.nomtek.domain.mapper

import com.nomtek.domain.model.PostViewModel
import com.nomtek.domain.api.model.PostApiModel
import javax.inject.Inject

open class PostApiModelToViewModelMapper @Inject constructor() {

    open fun mapPostApiModelToViewModel(postApiModel: PostApiModel): PostViewModel {
        return PostViewModel(
            userId = postApiModel.userId,
            id = postApiModel.id,
            title = postApiModel.title,
            body = postApiModel.body
        )
    }
}