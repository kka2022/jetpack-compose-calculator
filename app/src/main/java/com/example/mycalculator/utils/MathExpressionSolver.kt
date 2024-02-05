package com.example.mycalculator.utils

fun evaluator(expression: String): String {
    // expressionString received must not have trailing operators
    var listOfNumbersAndOperators = mutableListOf<String>()
    var startingIndex = 0
    var endIndex = 0
    for (i in expression.indices) {
        // increment endIndex if value at current index is a digit
        if (expression[i].toString() in setOfDigits) {
            // if we reached at end of string, then add the numberString to list
            if (i == expression.length - 1) {
                listOfNumbersAndOperators.add(expression.substring(startingIndex))
            }
            endIndex++
        } else if (expression[i].toString() in setOfOperators) {
            // if an operator is found, then add numberString to list
            // and then add operator to list
            listOfNumbersAndOperators.add(expression.substring(startingIndex, endIndex))
            listOfNumbersAndOperators.add(expression[i].toString())

            startingIndex = i + 1
            endIndex = startingIndex
        }
    }

    // divide
    var currentOperator = OPERATOR.DIVIDE.symbol
    while (listOfNumbersAndOperators.contains(currentOperator)) {
        val divideOpIndex = listOfNumbersAndOperators.indexOf(currentOperator)
        val firstNumber = listOfNumbersAndOperators[divideOpIndex - 1]
        val secondNumber = listOfNumbersAndOperators[divideOpIndex + 1]
        val operationResult = solve(firstNumber, secondNumber, currentOperator)
        listOfNumbersAndOperators = listOfNumbersAndOperators.mapIndexed { index, s ->
            if (index == divideOpIndex) {
                operationResult
            } else {
                s
            }
        }.toMutableList()
        listOfNumbersAndOperators = listOfNumbersAndOperators.filterIndexed { index, _ ->
            !((index == divideOpIndex - 1) || (index == divideOpIndex + 1))
        }.toMutableList()
    }

    // multiply
    currentOperator = OPERATOR.MULTIPLY.symbol
    while (listOfNumbersAndOperators.contains(currentOperator)) {
        val divideOpIndex = listOfNumbersAndOperators.indexOf(currentOperator)
        val firstNumber = listOfNumbersAndOperators[divideOpIndex - 1]
        val secondNumber = listOfNumbersAndOperators[divideOpIndex + 1]
        val operationResult = solve(firstNumber, secondNumber, currentOperator)
        listOfNumbersAndOperators = listOfNumbersAndOperators.mapIndexed { index, s ->
            if (index == divideOpIndex) {
                operationResult
            } else {
                s
            }
        }.toMutableList()
        listOfNumbersAndOperators = listOfNumbersAndOperators.filterIndexed { index, _ ->
            !((index == divideOpIndex - 1) || (index == divideOpIndex + 1))
        }.toMutableList()
    }

    // plus and minus
    var operationType = OPERATOR.PLUS.symbol
    var totalValue = 0.0
    for (element in listOfNumbersAndOperators) {
        if (element in setOf(OPERATOR.PLUS.symbol, OPERATOR.MINUS.symbol)) {
            operationType = element
        } else {
            val elementValue = element.toDoubleOrNull()
            if (elementValue != null) {
                if (operationType == OPERATOR.PLUS.symbol) {
                    totalValue += elementValue
                } else if (operationType == OPERATOR.MINUS.symbol) {
                    totalValue -= elementValue
                }
            }
        }
    }
    return totalValue.toString()
}


fun solve(firstOperand: String, secondOperand: String, operator: String): String {
    if ((firstOperand.toDoubleOrNull() != null) && (secondOperand.toDoubleOrNull() != null)) {
        return when (operator) {
            OPERATOR.PLUS.symbol -> {
                (firstOperand.toDoubleOrNull()!! + secondOperand.toDoubleOrNull()!!).toString()
            }

            OPERATOR.MINUS.symbol -> {
                (firstOperand.toDoubleOrNull()!! - secondOperand.toDoubleOrNull()!!).toString()
            }

            OPERATOR.MULTIPLY.symbol -> {
                (firstOperand.toDoubleOrNull()!! * secondOperand.toDoubleOrNull()!!).toString()
            }

            OPERATOR.DIVIDE.symbol -> {
                (firstOperand.toDoubleOrNull()!! / secondOperand.toDoubleOrNull()!!).toString()
            }

            else -> {
                ""
            }
        }
    }
    return ""
}

enum class OPERATOR(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("×"),
    DIVIDE("÷"),
}

enum class DIGIT(val digit: String) {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    DECIMAL(".")
}

val setOfOperators = enumValues<OPERATOR>().map { it.symbol }.toSet()
val setOfDigits = enumValues<DIGIT>().map { it.digit }.toSet()