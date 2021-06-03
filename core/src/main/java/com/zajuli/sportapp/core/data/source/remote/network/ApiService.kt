package com.zajuli.sportapp.core.data.source.remote.network

import com.zajuli.sportapp.core.data.source.remote.response.ListTourismResponse
import retrofit2.http.GET

interface ApiService {
    @GET("all_sports.php")
    suspend fun getList(): ListTourismResponse
}
