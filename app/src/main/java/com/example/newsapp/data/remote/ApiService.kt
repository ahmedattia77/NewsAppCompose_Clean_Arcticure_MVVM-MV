package com.example.newsapp.data.remote

import com.example.newsapp.data.remote.dto.NewsResponse
import com.example.newsapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/everything?apiKey=${Constants.API_KEY}")
    suspend fun getArticles(
        @Query("page") page: Int,
        @Query("sources") sources: String,
    ): NewsResponse

    @GET("v2/everything?apiKey=${Constants.API_KEY}")
    suspend fun searchArticles(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
    ): NewsResponse

}