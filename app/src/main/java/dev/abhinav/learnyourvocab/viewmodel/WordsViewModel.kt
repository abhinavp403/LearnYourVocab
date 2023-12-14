package dev.abhinav.learnyourvocab.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WordsViewModel : ViewModel() {

    val word1 = mutableStateOf("")
    val word2 = mutableStateOf("")
    val word3 = mutableStateOf("")
    val word4 = mutableStateOf("")
    val word5 = mutableStateOf("")
}