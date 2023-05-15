package com.shyam.schoolslist.di.module

import android.content.Context
import com.shyam.schoolslist.MyApplication
import com.shyam.schoolslist.di.ApplicationContext
import com.shyam.schoolslist.di.BaseUrl
import com.shyam.schoolslist.domain.api.GetSchoolsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule(private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String {
        return "https://catalogue.data.govt.nz/"
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

//    @Provides
//    @Singleton
//    fun provideGetSchoolsApiService(
//        @BaseUrl baseUrl: String,
//
//    ): GetSchoolsApiService {
//        return Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(gsonConverterFactory)
//            .build()
//            .create(GetSchoolsApiService::class.java)
//    }

    @Provides
    fun provideRetrofitClient(@BaseUrl baseUrl: String, gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideGetSchoolsApiService(retrofit: Retrofit): GetSchoolsApiService {
        return retrofit.create(GetSchoolsApiService::class.java)
    }

}