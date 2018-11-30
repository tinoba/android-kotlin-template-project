package com.tinoba.data.repository

import com.tinoba.data.network.service.TemplateClient
import com.tinoba.domain.repository.NewsRepository

class NewsRepositoryImpl(private val templateClient: TemplateClient) : NewsRepository {

    override fun news() = templateClient.getNews()
}