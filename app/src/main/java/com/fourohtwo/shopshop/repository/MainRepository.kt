package com.fourohtwo.shopshop.repository

import com.fourohtwo.shopshop.data.remote.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
){
    suspend fun getPhotos() = apiHelper.getPhotos()
}