package com.tinoba.data.network.service

import com.tinoba.data.network.model.ApiNewsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface TemplateService {

    @GET("v2/top-headlines?country=us&category=business&apiKey=17527b813c9c453d85e7635af041897e")
    fun getNews(): Single<ApiNewsResponse>
}