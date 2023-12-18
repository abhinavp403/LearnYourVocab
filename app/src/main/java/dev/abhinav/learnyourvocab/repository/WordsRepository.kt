package dev.abhinav.learnyourvocab.repository

import dev.abhinav.learnyourvocab.model.Meanings
import dev.abhinav.learnyourvocab.remote.WordsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WordsRepository @Inject constructor (private val api: WordsApi) {

    suspend fun getDefinition(word: String) : List<Meanings> {
        return try {
            val response = api.getDefinition(word)
            val wordFromResponse = response[0]
            wordFromResponse.meanings
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}
