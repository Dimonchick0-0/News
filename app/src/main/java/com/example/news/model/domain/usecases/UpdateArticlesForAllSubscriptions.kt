package com.example.news.model.domain.usecases

import com.example.news.model.domain.repository.NewsRepository
import javax.inject.Inject

class UpdateArticlesForAllSubscriptions @Inject constructor(
    private val repository: NewsRepository
) {

    suspend operator fun invoke() {
        repository.updateArticlesForAllSubscriptions()
    }

}