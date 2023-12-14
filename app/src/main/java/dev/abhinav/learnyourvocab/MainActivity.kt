package dev.abhinav.learnyourvocab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.abhinav.learnyourvocab.ui.theme.LearnYourVocabTheme
import dev.abhinav.learnyourvocab.viewmodel.WordsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnYourVocabTheme {
                val navController = rememberNavController()
                val viewModel = remember { WordsViewModel() }
                NavHost(
                    navController = navController,
                    startDestination = "enter_words_screen"
                ) {
                    composable("enter_words_screen") {
                        EnterWordScreen(
                            viewModel = viewModel,
                            onButtonClicked = {
                                navController.navigate("display_words_screen")
                            }
                        )
                    }
                    composable("display_words_screen") {
                        DisplayWordScreen(viewModel)
                    }
                }
            }
        }
    }
}