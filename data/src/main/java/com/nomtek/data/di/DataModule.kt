package com.nomtek.data.di

import com.nomtek.data.api.MainApiService
import com.nomtek.data.repository.MainRepositoryImpl
import com.nomtek.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideMainRepository(mainApiService: MainApiService): MainRepository {
        return MainRepositoryImpl(mainApiService)
    }
}