package com.shyam.schoolslist.domain.repository

import com.shyam.schoolslist.domain.api.GetSchoolsApiService
import org.junit.Test
import org.mockito.kotlin.mock


class SchoolsRepositoryTest {
    private val apiService = mock<GetSchoolsApiService>()
    private val repository = SchoolsRepository(apiService)

    @Test
    fun `getSchools - `() {

    }

}