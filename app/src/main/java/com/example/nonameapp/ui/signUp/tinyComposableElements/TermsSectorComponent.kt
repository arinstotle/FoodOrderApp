package com.example.nonameapp.ui.signUp.tinyComposableElements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpRouter
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpScreen

@Composable
fun TermsSectorComponent(startedCheckedState : Boolean) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(50.dp)
        .padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
        val checkedState = remember {
            mutableStateOf(startedCheckedState)
        }
        Checkbox( checked = checkedState.value, onCheckedChange = {
            checkedState.value = !checkedState.value
        } )
        TermTextComponent(onTextSelected = { s1, s2, s3 ->
            when(s3) {
                s1 -> SignUpRouter.navigateTo(SignUpScreen.PrivacyPolicyScreen)
                s2 -> {}
            }
        })
    }
}