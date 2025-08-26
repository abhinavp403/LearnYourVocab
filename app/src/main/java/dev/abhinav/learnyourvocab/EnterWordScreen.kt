package dev.abhinav.learnyourvocab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.radusalagean.infobarcompose.InfoBar
import dev.abhinav.learnyourvocab.ui.CustomMessage
import dev.abhinav.learnyourvocab.ui.theme.LearnYourVocabTheme
import dev.abhinav.learnyourvocab.util.PreferencesManager
import java.time.LocalDate

@Composable
fun EnterWordScreen(onButtonClicked: () -> Unit) {

    val context = LocalContext.current
    var message: CustomMessage? by remember { mutableStateOf(null) }
    val sharedPreference = remember { PreferencesManager(context) }
    var word1 by remember { mutableStateOf("") }
    var word2 by remember { mutableStateOf("") }
    var word3 by remember { mutableStateOf("") }
    var word4 by remember { mutableStateOf("") }
    var word5 by remember { mutableStateOf("") }

    val content: @Composable (CustomMessage) -> Unit = {
        Row {
            Text(
                modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp),
                text = it.textString,
                color = it.textColor
            )
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp).systemBarsPadding()
    ) {
        Text(
            text = "Enter your words for the week!",
            style = MaterialTheme.typography.headlineLarge,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = word1,
            onValueChange = { word1 = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 1") },
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = word2,
            onValueChange = { word2 = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 2") },
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = word3,
            onValueChange = { word3 = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 3") },
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = word4,
            onValueChange = { word4 = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 4") },
            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = word5,
            onValueChange = { word5 = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            label = { Text("Enter Word 5") },
            keyboardOptions = KeyboardOptions.Default.copy(
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
                if (word1.isBlank() || word2.isBlank() || word3.isBlank() || word4.isBlank() || word5.isBlank()) {
                    message = CustomMessage(
                        textString = "Please Input All 5 Words!",
                        textColor = Color(0xFF2B2B2B),
                        backgroundColor = Color(0xFFE74242)
                    )
                } else {
                    sharedPreference.setWord1(word1)
                    sharedPreference.setWord2(word2)
                    sharedPreference.setWord3(word3)
                    sharedPreference.setWord4(word4)
                    sharedPreference.setWord5(word5)
                    setLocalDateInfo(sharedPreference)
                    onButtonClicked.invoke()
                }
            }
        ) {
            Text(
                text = "Submit",
                fontSize = 16.sp
            )
        }
        InfoBar(offeredMessage = message, content = content) {
            message = null
        }
    }
}

private fun setLocalDateInfo(sharedPreference: PreferencesManager) {
    val currentDate = LocalDate.now()
    val nextRefreshDate = currentDate.plusDays(7)
    sharedPreference.setDate(nextRefreshDate)
}

@Preview(showBackground = true)
@Composable
fun EnterWordScreenPreview() {
    LearnYourVocabTheme {
        EnterWordScreen {}
    }
}
