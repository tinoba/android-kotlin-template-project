package com.tinoba.template.appliaction

import android.app.Application
import android.content.Context
import com.tinoba.template.dagger.ComponentFactory
import com.tinoba.template.dagger.application.ApplicationComponent

class TemplateApplication : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    companion object {
        fun from(context: Context): TemplateApplication {
            return context.applicationContext as TemplateApplication
        }
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = ComponentFactory.createApplicationComponent(this)
        applicationComponent.inject(this)
    }

    fun getApplicationComponent() = applicationComponent
}