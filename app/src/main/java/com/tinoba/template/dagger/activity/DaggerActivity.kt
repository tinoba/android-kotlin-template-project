package com.tinoba.template.dagger.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tinoba.template.appliaction.TemplateApplication
import com.tinoba.template.dagger.ComponentFactory

abstract class DaggerActivity : AppCompatActivity() {

    private var activityComponent: ActivityComponent? = null

    private fun getTemplateApplication() = TemplateApplication.from(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(getActivityComponent())
    }

    fun getActivityComponent(): ActivityComponent {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this, getTemplateApplication().getApplicationComponent())
        }

        return activityComponent as ActivityComponent
    }

    protected abstract fun inject(activityComponent: ActivityComponent)
}
