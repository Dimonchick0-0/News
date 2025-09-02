package com.example.news.model.domain.usecases

import com.example.news.model.domain.repository.NewsRepository
import javax.inject.Inject

class ClearAllArticles @Inject constructor(
    private val repository: NewsRepository
) {

    suspend operator fun invoke(listTopic: List<String>) {
        repository.clearAllArticles(listTopic)
    }

}