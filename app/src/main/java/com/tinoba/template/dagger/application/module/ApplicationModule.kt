package com.tinoba.template.dagger.application.module

import android.content.Context
import com.tinoba.template.appliaction.TemplateApplication
import com.tinoba.template.dagger.application.ForApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val templateApplication: TemplateApplication) {

    @Provides
    @Singleton
    internal fun provideMercuryApplication(): TemplateApplication {
        return templateApplication
    }

    @Provides
    @Singleton
    @ForApplication
    internal fun provideContext(): Context {
        return templateApplication
    }

    interface Exposes {

        fun mercuryApplication(): TemplateApplication

        @ForApplication
        fun context(): Context
    }
}
