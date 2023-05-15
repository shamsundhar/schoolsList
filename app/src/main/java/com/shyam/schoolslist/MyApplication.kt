package com.shyam.schoolslist

import android.app.Application
import com.shyam.schoolslist.di.component.ApplicationComponent
import com.shyam.schoolslist.di.component.DaggerApplicationComponent
import com.shyam.schoolslist.di.module.ApplicationModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication :  Application(){

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}