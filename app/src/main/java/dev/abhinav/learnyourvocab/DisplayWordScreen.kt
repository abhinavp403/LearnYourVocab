package dev.abhinav.learnyourvocab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.abhinav.learnyourvocab.ui.theme.LearnYourVocabTheme
import dev.abhinav.learnyourvocab.util.PreferencesManager

@Composable
fun DisplayWordScreen(navController: NavHostController) {

    val context = LocalContext.current
    val sharedPreference = remember { PreferencesManager(context) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Text(
            text = "Click on any word to get started!",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = sharedPreference.getWord1()!!,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${sharedPreference.getWord1()}")
                }
        )
        Text(
            text = sharedPreference.getWord2()!!,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${sharedPreference.getWord2()}")
                }
        )
        Text(
            text = sharedPreference.getWord3()!!,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${sharedPreference.getWord3()}")
                }
        )
        Text(
            text = sharedPreference.getWord4()!!,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${sharedPreference.getWord4()}")
                }
        )
        Text(
            text = sharedPreference.getWord5()!!,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${sharedPreference.getWord5()}")
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayWordScreenPreview() {
    LearnYourVocabTheme {
        DisplayWordScreen(rememberNavController())
    }
}