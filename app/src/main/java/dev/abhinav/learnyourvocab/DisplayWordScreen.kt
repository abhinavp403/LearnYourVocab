package dev.abhinav.learnyourvocab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.abhinav.learnyourvocab.ui.theme.LearnYourVocabTheme
import dev.abhinav.learnyourvocab.viewmodel.WordsViewModel

@Composable
fun DisplayWordScreen(viewModel: WordsViewModel, navController: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Click on any word to get started!",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = viewModel.word1.value,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${viewModel.word1.value}")
                }
        )
        Text(
            text = viewModel.word2.value,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${viewModel.word2.value}")
                }
        )
        Text(
            text = viewModel.word3.value,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${viewModel.word3.value}")
                }
        )
        Text(
            text = viewModel.word4.value,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${viewModel.word4.value}")
                }
        )
        Text(
            text = viewModel.word5.value,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            maxLines = 1,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate("word_detail_screen/${viewModel.word5.value}")
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayWordScreenPreview() {
    LearnYourVocabTheme {
        DisplayWordScreen(WordsViewModel(), rememberNavController())
    }
}