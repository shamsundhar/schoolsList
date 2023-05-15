package com.shyam.schoolslist.domain.api

import com.shyam.schoolslist.domain.model.SchoolEntity
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface GetSchoolsApiService {
    @GET("api/3/action/datastore_search")
    suspend fun getSchools(@Query("resource_id") resourceId: String, @Query("limit") limit: String): List<SchoolEntity>
}