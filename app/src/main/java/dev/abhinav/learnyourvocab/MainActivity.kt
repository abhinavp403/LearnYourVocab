package dev.abhinav.learnyourvocab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.ai.client.generativeai.GenerativeModel
import dagger.hilt.android.AndroidEntryPoint
import dev.abhinav.learnyourvocab.ui.theme.LearnYourVocabTheme
import dev.abhinav.learnyourvocab.util.PreferencesManager
import java.time.LocalDate
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var sharedPreference: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference = PreferencesManager(this)
        setContent {
            LearnYourVocabTheme {
                val navController = rememberNavController()
                val compareDateResult = LocalDate.now().compareTo(sharedPreference.getDate())
                NavHost(
                    navController = navController,
                    startDestination = if(compareDateResult < 0) "display_words_screen"
                                    else "enter_words_screen"
                ) {
                    composable("enter_words_screen") {
                        setLocalDateInfo()
                        EnterWordScreen(
                            onButtonClicked = {
                                navController.navigate("display_words_screen") {
                                    popUpTo("enter_words_screen") {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                    composable("display_words_screen") {
                        DisplayWordScreen(navController)
                    }
                    composable("word_detail_screen/{word}",
                        arguments = listOf(
                            navArgument("word") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val word = remember {
                            it.arguments!!.getString("word")
                        }
                        val generativeModel = GenerativeModel(
                            modelName = "gemini-pro",
                            apiKey = BuildConfig.apiKey
                        )
                        WordDetailScreen(
                            clickedWord = word?.toLowerCase(Locale.ROOT) ?: "",
                            navController = navController,
                            model = generativeModel
                        )
                    }
                }
            }
        }
    }

    private fun setLocalDateInfo() {
        val currentDate = LocalDate.now()
        val nextRefreshDate = currentDate.plusDays(7)
        sharedPreference.setDate(nextRefreshDate)
    }
}