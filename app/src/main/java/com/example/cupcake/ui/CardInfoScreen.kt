package com.example.cupcake.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cupcake.R

@Composable
fun CardInfoScreen(
    onDoneButtonClicked: (CardInfo, String) -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var expiration by remember { mutableStateOf("") }
    var secCode by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter Card Information", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name on Card") })
        OutlinedTextField(value = cardNumber, onValueChange = { cardNumber = it }, label = { Text("Card Number") })
        OutlinedTextField(value = expiration, onValueChange = { expiration = it }, label = { Text("Expiration (MM/YY)") })
        OutlinedTextField(value = secCode, onValueChange = { secCode = it }, label = { Text("Security Code") })
        OutlinedTextField(value = address, onValueChange = { address = it }, label = { Text("Shipping Address") })
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onCancelButtonClicked) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                onClick = {
                    val cardInfo = CardInfo(name, cardNumber, expiration, secCode)
                    onDoneButtonClicked(cardInfo, address)
                },
                enabled = name.isNotEmpty() && cardNumber.isNotEmpty() && expiration.isNotEmpty() && secCode.isNotEmpty() && address.isNotEmpty()
            ) {
                Text("Done")
            }
        }
    }
}

data class CardInfo(
    val name: String,
    val number: String,
    val expiration: String,
    val secCode: String
)