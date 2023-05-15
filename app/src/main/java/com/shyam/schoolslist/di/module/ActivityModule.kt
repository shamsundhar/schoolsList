package com.shyam.schoolslist.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

//    @Provides
//    fun provideSchoolsListViewModel(schoolsRepository: SchoolsRepository): SchoolsListViewModel {
//        return ViewModelProvider(activity,
//            ViewModelProviderFactory(SchoolsListViewModel::class) {
//                SchoolsListViewModel(schoolsRepository)
//            })[SchoolsListViewModel::class.java]
//    }
}