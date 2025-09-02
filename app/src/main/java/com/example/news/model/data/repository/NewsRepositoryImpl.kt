package com.example.news.model.data.repository

import com.example.news.model.domain.entity.Article
import com.example.news.model.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl : NewsRepository {
    override fun getAllSubscriptions(): Flow<List<String>> {
        TODO("Not yet implemented")
    }

    override suspend fun addSubscriptions(topic: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateArticlesForTopic(topic: String) {
        TODO("Not yet implemented")
    }

    override suspend fun removeSubscription(topic: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateArticlesForAllSubscriptions() {
        TODO("Not yet implemented")
    }

    override fun getArticlesByTopics(topic: List<String>): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun clearAllArticles(listTopic: List<String>) {
        TODO("Not yet implemented")
    }
}