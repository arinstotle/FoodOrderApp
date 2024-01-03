package com.example.nonameapp.ui.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.nonameapp.R
import com.example.nonameapp.ui.signUp.signUpNavigation.BackHandler
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpRouter
import com.example.nonameapp.ui.signUp.signUpNavigation.SignUpScreen
import com.example.nonameapp.ui.signUp.tinyComposableElements.ButtonComponent
import com.example.nonameapp.ui.signUp.tinyComposableElements.DividerComponent
import com.example.nonameapp.ui.signUp.tinyComposableElements.OrdinaryTextComponent
import com.example.nonameapp.ui.signUp.tinyComposableElements.PasswordTextFieldComponent
import com.example.nonameapp.ui.signUp.tinyComposableElements.SocialNetworksComponent
import com.example.nonameapp.ui.signUp.tinyComposableElements.TextFieldComponent
import com.example.nonameapp.ui.signUp.tinyComposableElements.ToRegisterTextComponent
import com.example.nonameapp.ui.theme.Black1_28
import com.example.nonameapp.ui.theme.OrangeD8
import com.example.nonameapp.viewModels.AuthorizationViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginComposable(
    mViewModel: AuthorizationViewModel,
    afterLoginAction : () -> Unit
) {
    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
               Black1_28
            )
            .padding(0.dp)
            .verticalScroll(ScrollState(0))
    ) {
        BackHandler {
            SignUpRouter.navigateTo(SignUpScreen.RegistrationScreen)
        }
        Box(modifier = Modifier.fillMaxSize().background(Black1_28)) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(Color.Transparent)
                    .align(Alignment.Center)
                    .size(700.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.meat_sticker),
                    contentDescription = null
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            ) {

                var emailString by remember { mutableStateOf("") }
                var passwordString by remember { mutableStateOf("") }
                var showError by remember { mutableStateOf(false) }
                var errorMessage by remember { mutableStateOf("") }

                OrdinaryTextComponent(
                    content = stringResource(id = R.string.hello),
                    topPadding = 24,
                    color = OrangeD8
                )
                OrdinaryTextComponent(
                    content = stringResource(id = R.string.welcome), topPadding = 8,
                    size = 26,
                    fontWeight = FontWeight.Bold,
                    heightMin = 0,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextFieldComponent(labelValue = stringResource(id = R.string.email),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    onChangeTextAction = {
                        emailString = it
                    },
                    iconResource = {
                        Icon(
                            painter = painterResource(id = R.drawable.email1_icon),
                            contentDescription = ""
                        )
                    })
                Spacer(modifier = Modifier.height(16.dp))
                PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password),
                    onChangeTextAction = {
                        passwordString = it
                    }
                )
                if(showError){
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = errorMessage,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp),
                        color = MaterialTheme.colorScheme.error
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                ButtonComponent(text = stringResource(id = R.string.login_button)) {
                    showError = false

                    scope.launch {
                        val responseCode = mViewModel.loginIntoAccount(emailString, passwordString)

                        when (responseCode) {
                            200 -> {
                                afterLoginAction()
                            }
                            400 -> {
                                showError = true
                                errorMessage = "Invalid password!"
                            }
                            else -> {
                                showError = true
                                errorMessage = "Error! ($responseCode)"
                            }
                        }
                    }
                }
                DividerComponent()
                SocialNetworksComponent(
                    icon1 = ImageVector.vectorResource(R.drawable.google_icon),
                    icon2 = ImageVector.vectorResource(R.drawable.facebook_icon),
                    onIcon1Click = { /*TODO*/ },
                ) {
                }
                ToRegisterTextComponent()
            }
        }
    }
}