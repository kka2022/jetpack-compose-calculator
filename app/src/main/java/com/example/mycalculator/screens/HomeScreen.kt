package com.example.mycalculator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycalculator.components.ButtonsGrid
import com.example.mycalculator.components.DisplayArea
import com.example.mycalculator.model.DigitButtonsList
import com.example.mycalculator.model.OperatorButtonsList
import com.example.mycalculator.model.OtherButtonsList

@Preview(showBackground = true, widthDp = 320)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val displayViewModel = viewModel<DisplayViewModel>()

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // display calculation history
            DisplayArea(
                modifier = Modifier,
                valueToDisplay = displayViewModel.lastCalculation.value,
            )
            Spacer(modifier = Modifier.height(20.dp))

            // display current state
            DisplayArea(
                modifier = Modifier,
                valueToDisplay = displayViewModel.expression.value,
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Arrange Buttons
            ButtonsGrid(modifier = Modifier.height(400.dp)) { button ->
                val digitButtonsList = DigitButtonsList.digitButtonsList
                val operatorButtonsList = OperatorButtonsList.operatorButtonsList

                when (button) {
                    in digitButtonsList -> {
                        displayViewModel.addDigitOrOperator(button.textOrIcon.toString())
                    }

                    in operatorButtonsList -> {
                        val currentExpression = displayViewModel.expression.value
                        val lastCharacter = currentExpression.last().toString()

                        if (button.name == "equals") {
                            displayViewModel.makeCalculation(currentExpression)
                        }
                        // add operator to expression only when the last character is a digit
                        else if (lastCharacter in digitButtonsList.map {
                                it.textOrIcon.toString()
                            }.toSet()
                        ) {
                            if (lastCharacter != ".") {
                                displayViewModel.addDigitOrOperator(button.textOrIcon.toString())
                            }
                        }
                    }

                    in OtherButtonsList.otherButtonsList -> {
                        if (button.name == "delete") {
                            displayViewModel.deleteOneCharacter()
                        }
                        if (button.name == "all_clear") {
                            displayViewModel.allClear()
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}