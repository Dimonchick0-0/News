package com.example.news.model.domain.usecases

import com.example.news.model.domain.repository.NewsRepository
import javax.inject.Inject

class AddSubscriptionsUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    suspend operator fun invoke(topic: String) {
        repository.apply {
            addSubscriptions(topic)
            updateArticlesForTopic(topic)
        }
    }

}