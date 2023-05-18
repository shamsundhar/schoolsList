package com.shyam.composeui.domain.api


import com.shyam.composeui.domain.model.SchoolListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GetSchoolsApiService {
    @GET("api/3/action/datastore_search")
    suspend fun getSchools(
        @Query("resource_id") resourceId: String,
        @Query("limit") limit: String
    ): SchoolListResponse
}