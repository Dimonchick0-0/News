package com.example.news.model.data.local.appdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.news.model.data.local.dao.NewsDao
import com.example.news.model.data.local.model.ArticleDbModel
import com.example.news.model.data.local.model.SubscriptionDbModel

@Database(
    entities = [
        ArticleDbModel::class,
        SubscriptionDbModel::class
    ],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}