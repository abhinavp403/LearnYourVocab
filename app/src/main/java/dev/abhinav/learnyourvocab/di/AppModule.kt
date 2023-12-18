package dev.abhinav.learnyourvocab.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.abhinav.learnyourvocab.remote.WordsApi
import dev.abhinav.learnyourvocab.repository.WordsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideWordsRepository(api: WordsApi) = WordsRepository(api)

    @Singleton
    @Provides
    fun provideWordsApi() : WordsApi {
        return Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WordsApi::class.java)
    }
}