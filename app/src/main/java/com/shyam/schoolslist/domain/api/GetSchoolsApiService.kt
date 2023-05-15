package com.shyam.schoolslist.domain.api

import com.shyam.schoolslist.domain.model.SchoolListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GetSchoolsApiService {
    @GET("api/3/action/datastore_search")
    suspend fun getSchools(
        @Query("resource_id") resourceId: String,
        @Query("limit") limit: String
    ): SchoolListResponse
}