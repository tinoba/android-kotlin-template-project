package com.tinoba.template.dagger.application.module


import com.tinoba.domain.interactor.GetNewsUseCase
import com.tinoba.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase = GetNewsUseCase(newsRepository)


    interface Exposes {

        fun getNewsUseCase(): GetNewsUseCase
    }
}
