package com.fourohtwo.shopshop.data.remote

import com.fourohtwo.shopshop.data.model.MarsPhoto
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject

interface ApiHelper {

    /**
     * Returns a [List] of [MarsPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
): ApiHelper {
    override suspend fun getPhotos(): List<MarsPhoto>   = apiService.getPhotos()

    //override suspend fun getEmployees(): Response<EmployeeResponse>  = apiService.getEmployees()

}