package dev.abhinav.learnyourvocab.remote

import dev.abhinav.learnyourvocab.model.Word
import retrofit2.http.GET
import retrofit2.http.Path

interface WordsApi {

    @GET("entries/en/{word}")
    suspend fun getDefinition(
        @Path("word") word: String,
    ) : ArrayList<Word>
}