package com.example.news.model.domain.usecases

import com.example.news.model.domain.repository.NewsRepository
import javax.inject.Inject

class RemoveSubscription @Inject constructor(
    private val repository: NewsRepository
) {

    suspend operator fun invoke(topic: String) {
        repository.removeSubscription(topic)
    }

}
