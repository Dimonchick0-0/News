package com.example.news.model.domain.usecases

import com.example.news.model.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllSubscriptionsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(): Flow<List<String>> {
        return repository.getAllSubscriptions()
    }
}