package com.example.news.model.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything?apiKey=452203e76768431fa8e417af52c88569")
    suspend fun loadArticles(
        @Query("q") topic: String
    ): NewsResponseDto

}