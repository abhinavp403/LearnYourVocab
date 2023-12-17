package dev.abhinav.learnyourvocab.ui

import androidx.compose.ui.graphics.Color
import com.radusalagean.infobarcompose.BaseInfoBarMessage

class CustomMessage(
    val textString: String,
    val textColor: Color = Color.Unspecified,
    override val backgroundColor: Color? = null,
    override val displayTimeSeconds: Int? = 3,
) : BaseInfoBarMessage() {
    override val containsControls: Boolean = false
}