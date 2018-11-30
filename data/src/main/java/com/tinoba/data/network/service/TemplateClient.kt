package com.tinoba.data.network.service

import com.tinoba.domain.model.Article
import io.reactivex.Single

interface TemplateClient {

    fun getNews(): Single<List<Article>>
}