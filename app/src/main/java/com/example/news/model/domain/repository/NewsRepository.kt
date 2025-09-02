package com.example.news.model.domain.repository

import com.example.news.model.domain.entity.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getAllSubscriptions(): Flow<List<String>>

    suspend fun addSubscriptions(topic: String)

    suspend fun updateArticlesForTopic(topic: String)

    suspend fun removeSubscription(topic: String)

    suspend fun updateArticlesForAllSubscriptions()

    fun getArticlesByTopics(topic: List<String>): Flow<List<Article>>

    suspend fun clearAllArticles(listTopic: List<String>)
}