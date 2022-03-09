package com.fourohtwo.shopshop.data.remote

import com.fourohtwo.shopshop.data.model.MarsPhoto
import retrofit2.http.GET

interface ApiService {

    //@GET("employees")
    //suspend fun getEmployees():Response<EmployeeResponse>

    /**
     * Returns a [List] of [MarsPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}