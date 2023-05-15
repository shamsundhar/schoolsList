package com.shyam.schoolslist.di.component

import com.shyam.schoolslist.MainActivity
import com.shyam.schoolslist.di.ActivityScope
import com.shyam.schoolslist.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}