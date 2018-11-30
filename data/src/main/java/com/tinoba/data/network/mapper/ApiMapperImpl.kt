package com.tinoba.data.network.mapper

import com.tinoba.data.network.model.ApiNewsResponse
import com.tinoba.domain.model.Article

class ApiMapperImpl : ApiMapper {

    override fun toArticles(apiNewsResponse: ApiNewsResponse) = apiNewsResponse.let {
        it.articles.map {
                Article(it?.author.orEmpty() ,
                        it?.title.orEmpty(),
                        it?.description.orEmpty(),
                        it?.urlToImage.orEmpty())
            }
        }
}