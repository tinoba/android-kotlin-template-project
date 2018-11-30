package com.tinoba.domain.repository

import com.tinoba.domain.model.Article
import io.reactivex.Single

interface NewsRepository{

    fun news() : Single<List<Article>>
}