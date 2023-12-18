package dev.abhinav.learnyourvocab.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.abhinav.learnyourvocab.model.Meanings
import dev.abhinav.learnyourvocab.repository.WordsRepository
import javax.inject.Inject

@HiltViewModel
class DefinitionViewModel @Inject constructor(
    private val repository: WordsRepository
) : ViewModel() {

    suspend fun getDefinition(word: String): List<Meanings> {
        return repository.getDefinition(word)
    }
}