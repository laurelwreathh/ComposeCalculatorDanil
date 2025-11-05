package com.example.composecalculatordanil


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class UIComponents{

}

//
//CalculatorDisplay() - экран калькулятора
//
//CalculatorButton() - базовая кнопка
//
//OperationButton() - кнопка операций (оранжевая)
//
//SpecialButton() - специальные кнопки (красная)

@Composable
fun CalculatorDisplay(value: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(40, 40, 40, 150), androidx.compose.foundation.shape.RoundedCornerShape(10.dp))
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )
    }
}

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(70.dp, 65.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
    ) {
        Text(text = symbol, style = MaterialTheme.typography.headlineMedium)
    }

}

@Composable
fun OperationButton(
    symbol: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(70.dp, 65.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(255, 192, 0))
    ) {
        Text(text = symbol, style = MaterialTheme.typography.headlineMedium)
    }

}

@Composable
fun SpecialButton(
    symbol: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(70.dp, 65.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
    ) {
        Text(text = symbol, style = MaterialTheme.typography.headlineMedium)
    }

}




