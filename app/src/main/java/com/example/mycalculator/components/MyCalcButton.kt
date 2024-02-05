package com.example.mycalculator.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.model.CalcButton

@Composable
fun MyCalcButton(
    button: CalcButton,
    onButtonClick: (CalcButton) -> Unit,
    contentColor: Color,
    backgroundColor: Color,
) {
    Button(
        onClick = { onButtonClick(button) },
        modifier = Modifier.size(80.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        )
    ) {
        when (button.textOrIcon) {
            is ImageVector -> {
                Icon(
                    imageVector = button.textOrIcon,
                    contentDescription = button.name,
                    modifier = Modifier.size(20.dp)
                )
            }

            is String -> {
                Text(
                    text = button.textOrIcon,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp)
                )
            }
        }
    }
}