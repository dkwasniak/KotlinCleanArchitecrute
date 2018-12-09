package com.nomtek.domain.mapper

import com.nomtek.domain.api.model.PostApiModel
import com.nomtek.domain.model.PostViewModel
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class PostApiModelToViewModelMapperTest {

    lateinit var target: PostApiModelToViewModelMapper

    @Before
    fun setUp() {
        target = PostApiModelToViewModelMapper()
    }

    @Test
    fun testMapPostApiModelToViewModel() {
        //given
        val postApiModel = PostApiModel(1, 2, "str1", "str2")
        val postViewModel = PostViewModel(1, 2, "str1", "str2")

        //when
        val result = target.mapPostApiModelToViewModel(postApiModel)

        //then
        assertEquals(result, postViewModel)
    }
}