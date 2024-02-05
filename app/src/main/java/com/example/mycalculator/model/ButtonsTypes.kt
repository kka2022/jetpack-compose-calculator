package com.example.mycalculator.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert

data class CalcButton(val name: String, val textOrIcon: Any)

class DigitButtonsList {
    companion object {
        val digitButtonsList: List<CalcButton> = listOf(
            CalcButton(name = "one", textOrIcon = "1"),
            CalcButton(name = "two", textOrIcon = "2"),
            CalcButton(name = "three", textOrIcon = "3"),
            CalcButton(name = "four", textOrIcon = "4"),
            CalcButton(name = "five", textOrIcon = "5"),
            CalcButton(name = "six", textOrIcon = "6"),
            CalcButton(name = "seven", textOrIcon = "7"),
            CalcButton(name = "eight", textOrIcon = "8"),
            CalcButton(name = "nine", textOrIcon = "9"),
            CalcButton(name = "zero", textOrIcon = "0"),
            CalcButton(name = "decimal", textOrIcon = ".")
        )
    }
}

class OperatorButtonsList {
    companion object {
        val operatorButtonsList: List<CalcButton> = listOf(
            CalcButton(name = "divide", textOrIcon = "÷"),
            CalcButton(name = "multiply", textOrIcon = "×"),
            CalcButton(name = "plus", textOrIcon = "+"),
            CalcButton(name = "minus", textOrIcon = "-"),
            CalcButton(name = "equals", textOrIcon = "="),
            CalcButton(name = "percent", textOrIcon = "%"),
        )
    }
}

class OtherButtonsList {
    companion object {
        val otherButtonsList: List<CalcButton> = listOf(
            CalcButton(name = "all_clear", textOrIcon = "AC"),
            CalcButton(name = "delete", textOrIcon = Icons.Filled.ArrowBack),
            CalcButton(name = "extend", textOrIcon = Icons.Filled.MoreVert),
        )
    }
}