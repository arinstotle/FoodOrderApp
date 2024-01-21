package com.example.nonameapp.ui.newcard.components

import android.content.res.Configuration
import android.health.connect.datatypes.units.Length
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun TextFieldsComponent(
    onHolderNameChanged: (newText: String) -> Unit,
    onCardNumberChanged: (newText: String) -> Unit,
    onValidUntilChanged: (newText: String) -> Unit,
    onCVVChanged: (newText: String) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
    ) {
        CustomTextField(
            placeholderText = "Holder name",
            onValueChange = { newValue ->
                onHolderNameChanged(newValue)
            }
        )
        CustomTextField(
            placeholderText = "Card number",
            maxLength = 16,
            onValueChange = { newValue ->
                var str = newValue

                if(newValue.length == 16){
                    val regex = Regex("\\d{1,4}(?=(\\d{4})+(?!\\d))")

                    str = regex.replace(str) {
                            m -> m.value + " "
                    }
                }
                onCardNumberChanged(str)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CustomTextField(
                placeholderText = "Valid until",
                maxLength = 4,
                onValueChange = { newValue ->
                    var str = newValue
                    if(str.length == 4){
                        str = "${newValue[0]}${newValue[1]}/${newValue[2]}${newValue[3]}"
                    }
                    onValidUntilChanged(str)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(end = 20.dp)
            )

            CustomTextField(
                placeholderText = "CVV",
                maxLength = 3,
                onValueChange = { newValue ->
                    onCVVChanged(newValue)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal
                ),
                modifier = Modifier
                    .padding(start = 20.dp)
            )
        }

    }
}

@Composable
private fun CustomTextField(
    placeholderText: String,
    maxLength: Int = 50,
    onValueChange: (newValue: String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    modifier: Modifier = Modifier
){
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            if(newText.length <= maxLength) {
                text = newText
                onValueChange(newText)
            }
        },
        label = {
            Text(
                text = placeholderText,
                fontSize = 15.sp,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Unspecified,
            focusedContainerColor = Color.Unspecified,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
        ),
        keyboardOptions = keyboardOptions,
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TextFieldsComponentPreview() {
    AppTheme {
        Column {
            TextFieldsComponent(
                onHolderNameChanged = {},
                onCardNumberChanged = {},
                onCVVChanged = {},
                onValidUntilChanged = {}
            )
        }
    }
}