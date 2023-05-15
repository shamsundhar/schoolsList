package com.shyam.schoolslist.di.component

import android.content.Context
import com.shyam.schoolslist.MyApplication
import com.shyam.schoolslist.di.ApplicationContext
import com.shyam.schoolslist.di.module.ApplicationModule
import com.shyam.schoolslist.domain.api.GetSchoolsApiService
import com.shyam.schoolslist.domain.repository.SchoolsRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getSchoolService(): GetSchoolsApiService

    fun getSchoolRepository(): SchoolsRepository

}