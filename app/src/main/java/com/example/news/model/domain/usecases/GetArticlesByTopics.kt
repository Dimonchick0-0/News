package com.example.news.model.domain.usecases

import com.example.news.model.domain.entity.Article
import com.example.news.model.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesByTopics @Inject constructor(
    private val repository: NewsRepository
) {

    operator fun invoke(topic: List<String>): Flow<List<Article>> {
        return repository.getArticlesByTopics(topic)
    }

}