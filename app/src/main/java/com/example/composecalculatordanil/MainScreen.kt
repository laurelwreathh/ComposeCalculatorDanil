package com.example.composecalculatordanil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    val logic = CalculatorLogic()
    var displayValue by remember { mutableStateOf("0") }
    var firstNumber by remember { mutableStateOf<Double?>(null) }
    var operation by remember { mutableStateOf<String?>(null) }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(28, 28, 28, 255)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {

            CalculatorDisplay(value = displayValue)

            Spacer(modifier = Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                SpecialButton("C") {
                    displayValue = "0"
                    firstNumber = null
                    operation = null
                }
                OperationButton("/") {
                    firstNumber = displayValue.toDoubleOrNull()
                    operation = "/"
                    displayValue = "0"
                }
                OperationButton("x") {
                    firstNumber = displayValue.toDoubleOrNull()
                    operation = "x"
                    displayValue = "0"
                }
                OperationButton("-") {
                    firstNumber = displayValue.toDoubleOrNull()
                    operation = "-"
                    displayValue = "0"
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                for (n in 7..9) {
                    CalculatorButton(n.toString()) {
                        displayValue =
                            if (displayValue == "0") n.toString() else displayValue + n.toString()
                    }
                }
                OperationButton("+") {
                    firstNumber = displayValue.toDoubleOrNull()
                    operation = "+"
                    displayValue = "0"
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                for (n in 4..6) {
                    CalculatorButton(n.toString()) {
                        displayValue =
                            if (displayValue == "0") n.toString() else displayValue + n.toString()
                    }
                }
                OperationButton("=") {
                    val second = displayValue.toDoubleOrNull()
                    val first = firstNumber
                    val op = operation

                    if (first != null && second != null && op != null) {
                        try {
                            val result = when (op) {
                                "+" -> logic.add(first, second)
                                "-" -> logic.subtract(first, second)
                                "x" -> logic.multiply(first, second)
                                "/" -> logic.divide(first, second)
                                else -> 0.0
                            }
                            displayValue = if (result % 1 == 0.0)
                                result.toInt().toString()
                            else
                                result.toString()
                        } catch (e: Exception) {
                            displayValue = "Ошибка"
                        } finally {
                            firstNumber = null
                            operation = null
                        }
                    }
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                for (n in 1..3) {
                    CalculatorButton(n.toString()) {
                        displayValue =
                            if (displayValue == "0") n.toString() else displayValue + n.toString()
                    }
                }
                CalculatorButton("0") {
                    if (displayValue != "0") displayValue += "0"
                }
            }
        }
    }
}



