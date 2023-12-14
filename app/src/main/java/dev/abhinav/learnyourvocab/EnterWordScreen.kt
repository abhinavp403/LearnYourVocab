package dev.abhinav.learnyourvocab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.abhinav.learnyourvocab.ui.theme.LearnYourVocabTheme
import dev.abhinav.learnyourvocab.viewmodel.WordsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterWordScreen(viewModel: WordsViewModel, onButtonClicked: () -> Unit) {

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Enter your words for the week!",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = viewModel.word1.value,
            onValueChange = { viewModel.word1.value = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 1") },
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.word2.value,
            onValueChange = { viewModel.word2.value = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 2") },
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.word3.value,
            onValueChange = { viewModel.word3.value = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 3") },
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.word4.value,
            onValueChange = { viewModel.word4.value = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 4") },
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.word5.value,
            onValueChange = { viewModel.word5.value = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 5") },
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                onButtonClicked.invoke()
            }
        ) {
            Text(
                text = "Submit",
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EnterWordScreenPreview() {
    LearnYourVocabTheme {
        EnterWordScreen(WordsViewModel()) {}
    }
}
