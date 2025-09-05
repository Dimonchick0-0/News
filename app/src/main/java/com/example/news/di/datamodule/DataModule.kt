package com.example.news.di.datamodule

import android.content.Context
import androidx.room.Room
import com.example.news.model.data.local.appdatabase.NewsDatabase
import com.example.news.model.data.local.dao.NewsDao
import com.example.news.model.data.remote.NewsApiService
import com.example.news.model.data.repository.NewsRepositoryImpl
import com.example.news.model.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

    companion object {

        @Singleton
        @Provides
        fun provideJson(): Json {
            return Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            }
        }

        @Singleton
        @Provides
        fun provideConverterFactory(json: Json): Converter.Factory {
            return json.asConverterFactory("application/json".toMediaType())
        }

        @Singleton
        @Provides
        fun provideRetrofit(
            converter: Converter.Factory,
            baseUrl: String
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .build()
        }

        @Singleton
        @Provides
        fun provideNewsApi(): NewsApiService {
            val baseUrl = "https://newsapi.org/"
            val converter = provideJson()
            val retrofit = provideRetrofit(provideConverterFactory(converter), baseUrl)
            return retrofit.create()
        }

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