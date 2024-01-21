package com.example.nonameapp.ui.newcard

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nonameapp.R
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.CustomTopAppBarComposable
import com.example.nonameapp.ui.newcard.components.LargeCardComponent
import com.example.nonameapp.ui.newcard.components.TextFieldsComponent
import com.example.nonameapp.ui.signUp.tinyComposableElements.ButtonComponent
import com.example.nonameapp.ui.theme.AppTheme
import com.example.nonameapp.ui.theme.OrangeD8
import com.example.nonameapp.ui.theme.RedD8
import com.example.nonameapp.ui.theme.ReemKufi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewCardScreen(
    navController: NavController
) {
    var holderNameText by remember { mutableStateOf("") }
    var cardNumberText by remember { mutableStateOf("") }
    var validUntilText by remember { mutableStateOf("") }
    var cvvText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CustomTopAppBarComposable(
                titleText = stringResource(id = R.string.new_card_top_app_bar_title),
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                isHaveNavIcon = true,
                onNavIconClick = {
                    navController.popBackStack()
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            LargeCardComponent(
                holderNameText = holderNameText,
                cardNumbersText = cardNumberText,
                validUntilText = validUntilText,
                cvvText = cvvText,
                modifier = Modifier
                    .padding(top = 35.dp, start = 10.dp, end = 10.dp)
            )

            Column {
                TextFieldsComponent(
                    onHolderNameChanged = { newText ->
                        holderNameText = newText
                    },
                    onCardNumberChanged = { newText ->
                        cardNumberText = newText
                    },
                    onValidUntilChanged = { newText ->
                        validUntilText = newText
                    },
                    onCVVChanged = { newText ->
                        cvvText = "*".repeat(newText.length)
                    },
                    modifier = Modifier
                        .fillMaxHeight(fraction = 0.6f)
                        .padding(bottom = 50.dp)
                )

                Button(
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp)
                        .background(
                            brush = Brush.horizontalGradient(listOf(RedD8, OrangeD8)),
                            shape = RoundedCornerShape(30.dp)
                        ),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Unspecified
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.new_card_add_new_card),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 24.sp,
                        fontFamily = ReemKufi,
                        fontWeight = FontWeight.ExtraBold
                    )

                }
            }

        }
    }
}

@Preview(
    name = "MI9T (NIGHT)",
    device = "spec:width=1080px,height=2340px",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun NewCardPreviewNight() {
    AppTheme {
        NewCardScreen(rememberNavController())
    }
}