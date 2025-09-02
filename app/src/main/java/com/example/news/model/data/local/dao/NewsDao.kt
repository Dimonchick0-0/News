package com.example.news.model.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.news.model.data.local.model.ArticleDbModel
import com.example.news.model.data.local.model.SubscriptionDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("select * from subscriptions")
    fun getAllSubscriptions(): Flow<List<SubscriptionDbModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSubscription(subscriptionDbModel: SubscriptionDbModel)

    @Transaction
    @Delete
    suspend fun deleteSubscription(subscriptionDbModel: SubscriptionDbModel)

    @Query("select * from article where topic in (:topics) order by publishedAt desc")
    fun getAllArticlesByTopics(topics: List<String>): Flow<List<ArticleDbModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addArticles(articles: List<ArticleDbModel>)

    @Query("delete from article where topic in (:topics)")
    suspend fun deleteArticlesByTopics(topics: List<String>)
}