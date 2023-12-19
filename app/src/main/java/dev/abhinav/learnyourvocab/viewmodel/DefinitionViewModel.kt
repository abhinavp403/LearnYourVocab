package dev.abhinav.learnyourvocab.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.abhinav.learnyourvocab.repository.WordsRepository
import javax.inject.Inject

@HiltViewModel
class DefinitionViewModel @Inject constructor(
    private val repository: WordsRepository
) : ViewModel() {

    private val definitionList = mutableListOf<String>()

    suspend fun getDefinition(word: String): MutableList<String> {
        val meanings = repository.getDefinition(word)
        for (meaning in meanings) {
            var defineItem = "(${meaning.partOfSpeech}) "
            var randomDefinition = meaning.definitions.random()
            defineItem += randomDefinition.definition
//            for (definition in meaning.definitions) {
//                defineItem += definition.definition
//                break
//            }
            definitionList.add(defineItem)
        }
        return definitionList
    }
}