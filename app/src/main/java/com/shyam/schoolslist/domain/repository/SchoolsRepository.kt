package com.shyam.schoolslist.domain.repository


import com.shyam.schoolslist.domain.model.SchoolEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolsRepository @Inject constructor(){
    fun getSchools(resource: String, limit: String) : Flow<List<SchoolEntity>> {
        return flow {
//            emit(apiService.getSchools(resource, limit))
        }
    }
}