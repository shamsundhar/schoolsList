//package com.shyam.schoolslist.ui.main.di
//
//import androidx.lifecycle.ViewModelProvider
//import com.shyam.schoolslist.domain.repository.SchoolsRepository
//import com.shyam.schoolslist.ui.base.ViewModelProviderFactory
//import com.shyam.schoolslist.ui.main.SchoolsListViewModel
//import dagger.Provides
//import dagger.multibindings.IntoMap
//
//abstract class SchoolListModule {
//
//    @Provides
//    @IntoMap
//    fun provideSchoolsListViewModel(schoolsRepository: SchoolsRepository): SchoolsListViewModel {
//        return ViewModelProvider(,
//            ViewModelProviderFactory(SchoolsListViewModel::class) {
//                SchoolsListViewModel(schoolsRepository)
//            })[SchoolsListViewModel::class.java]
//    }
//}