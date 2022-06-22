package com.magicapp.mvvm.data.remote

import com.magicapp.mvvm.data.local.entity.News
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("news")
    suspend fun addNews(@Body news: News): News

}