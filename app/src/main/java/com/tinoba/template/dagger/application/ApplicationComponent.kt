package com.tinoba.template.dagger.application

import com.tinoba.template.appliaction.TemplateApplication
import com.tinoba.template.dagger.application.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
                    ApplicationModule::class,
                    ThreadingModule::class,
                    DataModule::class,
                    UseCaseModule::class,
                    MapperModule::class,
                    UtilsModule::class
                    ]
)
interface ApplicationComponent : ApplicationComponentInjects, ApplicationComponentExposes {

    object Initializer {

        fun init(templateApplication: TemplateApplication): ApplicationComponent =
                DaggerApplicationComponent.builder()
                        .applicationModule(ApplicationModule(templateApplication))
                        .threadingModule(ThreadingModule())
                        .dataModule(DataModule())
                        .useCaseModule(UseCaseModule())
                        .build()

    }
}