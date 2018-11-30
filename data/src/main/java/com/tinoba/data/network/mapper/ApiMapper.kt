package com.tinoba.data.network.mapper

import com.tinoba.data.network.model.ApiNewsResponse
import com.tinoba.domain.model.Article

interface ApiMapper {

    fun toArticles(apiNewsResponse: ApiNewsResponse): List<Article>
}