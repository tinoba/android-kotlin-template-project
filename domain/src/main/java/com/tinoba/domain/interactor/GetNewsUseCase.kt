package com.tinoba.domain.interactor

import com.tinoba.domain.model.Article
import com.tinoba.domain.repository.NewsRepository

class GetNewsUseCase(private val newsRepository: NewsRepository) : QueryUseCase<List<Article>> {

    override fun run() = newsRepository.news()
}