package com.example.cupcake.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cupcake.R

@Composable
fun PaymentScreen(
    onNextButtonClicked: (String) -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedPayment by remember { mutableStateOf("") }
    val paymentOptions = listOf("Visa", "MasterCard", "Amex", "Discover")

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Select Payment Method", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))
            paymentOptions.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedPayment == option,
                        onClick = { selectedPayment = option }
                    )
                    Text(option, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onCancelButtonClicked) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                onClick = { if (selectedPayment.isNotEmpty()) onNextButtonClicked(selectedPayment) },
                enabled = selectedPayment.isNotEmpty()
            ) {
                Text("Next")
            }
        }
    }
}
