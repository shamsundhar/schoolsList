package com.shyam.schoolslist.domain.repository


import com.shyam.schoolslist.domain.api.GetSchoolsApiService
import com.shyam.schoolslist.domain.model.Record
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolsRepository @Inject constructor(private val apiService: GetSchoolsApiService){
    fun getSchools(resource: String, limit: String) : Flow<List<Record>> {
        return flow {
            emit(apiService.getSchools(resource, limit).result.records)
        }
    }
}