package com.tinoba.template.dagger.application.module

import android.os.Build
import com.google.gson.Gson
import com.tinoba.data.network.mapper.ApiMapper
import com.tinoba.data.network.service.TemplateClient
import com.tinoba.data.network.service.TemplateClientImpl
import com.tinoba.data.network.service.TemplateService
import com.tinoba.data.repository.NewsRepositoryImpl
import com.tinoba.domain.repository.NewsRepository
import com.tinoba.template.BuildConfig
import com.tinoba.template.util.OkHttpClientBuilderUtils
import com.tinoba.template.util.OkHttpClientBuilderUtilsImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {


    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClientBuilderUtils(): OkHttpClientBuilderUtils {
        return OkHttpClientBuilderUtilsImpl()
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(interceptor: HttpLoggingInterceptor, okHttpClientBuilderUtils: OkHttpClientBuilderUtils): OkHttpClient {
        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            builder.interceptors().add(interceptor)
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            okHttpClientBuilderUtils.setupTls(builder)
        }

        return builder.build()
    }

    @Provides
    @Singleton
    internal fun provideTemplateService(retrofit: Retrofit): TemplateService = retrofit.create(TemplateService::class.java)


    @Provides
    @Singleton
    internal fun provideTemplateClient(templateService: TemplateService, apiMapper: ApiMapper): TemplateClient =
            TemplateClientImpl(templateService, apiMapper)


    @Provides
    @Singleton
    internal fun provideNewsRepository(templateClient: TemplateClient): NewsRepository = NewsRepositoryImpl(templateClient)

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://newsapi.org/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    interface Exposes {

    }

}
