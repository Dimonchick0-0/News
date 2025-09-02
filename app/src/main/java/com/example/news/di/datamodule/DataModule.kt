package com.example.news.di.datamodule

import android.content.Context
import androidx.room.Room
import com.example.news.model.data.local.appdatabase.NewsDatabase
import com.example.news.model.data.local.dao.NewsDao
import com.example.news.model.data.repository.NewsRepositoryImpl
import com.example.news.model.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

    companion object {

        @Provides
        fun provideNewsDatabase(
            @ApplicationContext context: Context
        ): NewsDatabase {
            return Room.databaseBuilder(
                context = context,
                klass = NewsDatabase::class.java,
                name = "news.db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        @Singleton
        @Provides
        fun provideNewsDao(database: NewsDatabase): NewsDao {
            return database.newsDao()
        }

    }

}