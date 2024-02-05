package com.example.mycalculator.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.utils.AppColors

@Composable
fun DisplayArea(
    modifier: Modifier = Modifier,
    valueToDisplay: String,
) {
    Surface(modifier = modifier.height(150.dp).padding(8.dp)) {
        Box(modifier = Modifier, contentAlignment = Alignment.BottomEnd) {
            Text(
                text = valueToDisplay,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    textAlign = TextAlign.Right,
                    fontSize = 30.sp
                )
            )
        }
    }
}