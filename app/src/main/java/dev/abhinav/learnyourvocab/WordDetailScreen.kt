package dev.abhinav.learnyourvocab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.abhinav.learnyourvocab.viewmodel.DefinitionViewModel
import java.util.Locale

@Composable
fun WordDetailScreen(
    clickedWord: String,
    navController: NavController,
    viewModel: DefinitionViewModel = hiltViewModel()
) {
    val result = produceState<MutableList<String>>(initialValue = mutableListOf()) {
        value = viewModel.getDefinition(clickedWord)
    }.value

    if(result.isNotEmpty()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Text(
                text = clickedWord.capitalize(Locale.ROOT),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                maxLines = 1,
                modifier = Modifier.padding(8.dp)
            )
            WordDefinitionList(items = result, Modifier.align(Alignment.Start))
        }
    }
}

@Composable
fun WordDefinitionList(
    items: MutableList<String>,
    modifier: Modifier
) {
    val definition = items
        .mapIndexed { index, item -> "${index + 1}. $item" }
        .joinToString(separator = "\n")
    Text(
        text = definition,
        style = MaterialTheme.typography.bodySmall,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.sp,
        fontSize = 18.sp,
        modifier = modifier
    )
}