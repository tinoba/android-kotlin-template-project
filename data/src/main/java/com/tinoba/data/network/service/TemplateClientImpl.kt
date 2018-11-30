package com.tinoba.data.network.service

import com.tinoba.data.network.mapper.ApiMapper
import com.tinoba.domain.model.Article
import io.reactivex.Single

class TemplateClientImpl(private val templateService: TemplateService,
                         private val apiMapper: ApiMapper) : TemplateClient {

    override fun getNews(): Single<List<Article>> {
        return templateService.getNews()
                .map { it -> apiMapper.toArticles(it) }
    }
}