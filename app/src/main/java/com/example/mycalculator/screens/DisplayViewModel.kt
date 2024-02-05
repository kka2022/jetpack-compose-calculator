package com.example.mycalculator.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mycalculator.utils.DIGIT
import com.example.mycalculator.utils.evaluator
import com.example.mycalculator.utils.setOfOperators

class DisplayViewModel() : ViewModel() {
    var expression: MutableState<String> = mutableStateOf(DIGIT.ZERO.digit)
        private set

    var lastCalculation: MutableState<String> = mutableStateOf(DIGIT.ZERO.digit)
        private set

    fun addDigitOrOperator(digitOrOperator: String?) {
        expression.value = expression.value.let {
            if (it == DIGIT.ZERO.digit && !digitOrOperator.isNullOrEmpty()) {
                digitOrOperator
            } else {
                it + digitOrOperator
            }
        }
    }

    fun deleteOneCharacter() {
        expression.value = expression.value.let {
            when {
                it.length == 1 -> {
                    DIGIT.ZERO.digit
                }

                it.length > 1 -> {
                    it.substring(0, it.length - 1)
                }

                else -> {
                    DIGIT.ZERO.digit
                }
            }
        }
    }

    fun allClear() {
        expression.value = DIGIT.ZERO.digit
    }

    fun makeCalculation(stringToEvaluate: String) {
        var trimmedString = stringToEvaluate
        if (stringToEvaluate.last().toString() in setOfOperators) {
            trimmedString = stringToEvaluate.substring(0, stringToEvaluate.length - 1)
        }
        lastCalculation = mutableStateOf(trimmedString)
        expression.value = evaluator(trimmedString)
    }
}