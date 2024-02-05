package com.example.mycalculator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mycalculator.model.CalcButton
import com.example.mycalculator.utils.AppColors
import com.example.mycalculator.model.DigitButtonsList
import com.example.mycalculator.model.OperatorButtonsList
import com.example.mycalculator.model.OtherButtonsList

@Composable
fun ButtonsGrid(modifier: Modifier = Modifier, onButtonClick: (CalcButton) -> Unit = {}) {

    val digitButtonsList = DigitButtonsList.digitButtonsList
    val operatorButtonsList = OperatorButtonsList.operatorButtonsList
    val otherButtonsList = OtherButtonsList.otherButtonsList

    val buttonsGrid = listOf(
        listOf(
            otherButtonsList.find { it.name == "all_clear" },
            otherButtonsList.find { it.name == "delete" },
            operatorButtonsList.find { it.name == "percent" },
            operatorButtonsList.find { it.name == "divide" }),
        listOf(
            digitButtonsList.find { it.name == "seven" },
            digitButtonsList.find { it.name == "eight" },
            digitButtonsList.find { it.name == "nine" },
            operatorButtonsList.find { it.name == "multiply" },
        ),
        listOf(
            digitButtonsList.find { it.name == "four" },
            digitButtonsList.find { it.name == "five" },
            digitButtonsList.find { it.name == "six" },
            operatorButtonsList.find { it.name == "minus" },
        ),
        listOf(
            digitButtonsList.find { it.name == "one" },
            digitButtonsList.find { it.name == "two" },
            digitButtonsList.find { it.name == "three" },
            operatorButtonsList.find { it.name == "plus" },
        ),
        listOf(
            otherButtonsList.find { it.name == "extend" },
            digitButtonsList.find { it.name == "zero" },
            digitButtonsList.find { it.name == "decimal" },
            operatorButtonsList.find { it.name == "equals" },
        ),
    )

    Column(modifier = modifier) {
        buttonsGrid.forEach { buttonsRow ->
            Row {
                buttonsRow.forEach { button ->
                    if (button != null) {
                        val contentColor: Color = if (digitButtonsList.contains(button)) {
                            AppColors.mGray
                        } else {
                            AppColors.mOrange
                        }

                        MyCalcButton(
                            button = button,
                            onButtonClick = onButtonClick,
                            contentColor = contentColor,
                            backgroundColor = Color.White
                        )
                    }
                }
            }
        }
    }
}