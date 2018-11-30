package com.tinoba.domain.interactor

import io.reactivex.Single

interface QueryUseCase<Result> {

    fun run(): Single<Result>
}