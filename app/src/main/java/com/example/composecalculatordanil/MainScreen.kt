package com.example.composecalculatordanil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    var displayValue by remember { mutableStateOf("0") }
    val logic = remember { CalculatorLogic() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CalculatorDisplay(value = displayValue)

        // Простой пример кнопки
        CalculatorButton(
            symbol = "7",
            modifier = Modifier.size(80.dp)
        ) {
            displayValue = if (displayValue == "0") "7" else displayValue + "7"
        }
    }
}