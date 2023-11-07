package com.example.nonameapp.ui.signUp.tinyComposableElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.Black1_28_Transparent_30
import com.example.nonameapp.ui.theme.Black1_28_Transparent_50
import com.example.nonameapp.ui.theme.ReemKufi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(textValueStart : String = "",
                       labelValue : String,
                       onChangeTextAction: (String) -> Unit,
                       keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
                       iconResource : @Composable () -> Unit
) {
    val textValue = remember {
        mutableStateOf(textValueStart)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
        ,
        leadingIcon = iconResource,
        value = textValue.value,
        onValueChange = { textValue.value = it },
        shape = RoundedCornerShape(20.dp),
        textStyle = MaterialTheme.typography.titleMedium.copy(
            color = Color.White
        ),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            focusedLabelColor = Color.White,
            cursorColor = Color.White,
            containerColor = Black1_28_Transparent_50
        ),
        label = {
            Text(
                text = labelValue,
                fontFamily = ReemKufi
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(passwordStart : String = "",
                       labelValue : String,
                       onChangeTextAction: (String) -> Unit,
                       keyboardOptions: KeyboardOptions = KeyboardOptions.Default, ) {
    val password = remember {
        mutableStateOf(passwordStart)
    }
    val isVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
        ,
        leadingIcon = {
        Icon( painter = painterResource(id = R.drawable.password_icon), contentDescription = "")
        },
        value = password.value,
        onValueChange = { password.value = it },
        shape = RoundedCornerShape(20.dp),
        textStyle = MaterialTheme.typography.titleMedium.copy(
            color = Color.White
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            focusedLabelColor = Color.White,
            cursorColor = Color.White,
            containerColor = Black1_28_Transparent_50
        ),
        trailingIcon = {
            when(isVisible.value) {
                true -> IconButton( onClick = { isVisible.value = !isVisible.value }) {
                    Icon(
                    tint = Color.Gray,
                    painter = painterResource(id = R.drawable.eye_open_icon),
                    contentDescription = stringResource(id = R.string.password_show)) }
                false -> IconButton( onClick = { isVisible.value = !isVisible.value } ) {
                    Icon(
                    tint = Color.Gray,
                    painter = painterResource(id = R.drawable.eye_closed_icon),
                    contentDescription = stringResource(id = R.string.password_hide)) }
            }
        },
        label = {
            Text(
                text = labelValue,
                fontFamily = ReemKufi
            )
        },
        visualTransformation = if (isVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}