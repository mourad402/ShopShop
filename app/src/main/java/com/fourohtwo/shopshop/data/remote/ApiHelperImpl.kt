package com.fourohtwo.demoapp.api

import com.fourohtwo.shopshop.data.remote.ApiHelper
import com.fourohtwo.shopshop.data.remote.ApiService
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
): ApiHelper {

    //override suspend fun getEmployees(): Response<EmployeeResponse>  = apiService.getEmployees()

}