package com.shyam.composeui.domain.repository

import com.shyam.composeui.domain.api.GetSchoolsApiService
import com.shyam.composeui.domain.model.Record
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolsRepository @Inject constructor(private val apiService: GetSchoolsApiService){
    suspend fun getSchools(resource: String, limit: String) : List<Record> {
        return apiService.getSchools(resource, limit).result.records
    }
}