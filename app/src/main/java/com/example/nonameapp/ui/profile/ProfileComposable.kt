package com.example.nonameapp.ui.profile

import com.example.nonameapp.R
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "",
                            fontFamily = ReemKufi,
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.navigate(Screen.SettingsScreen.route)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Settings",
                                tint = FoodOnboardingGradient
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "Edit Profile",
                                tint = FoodOnboardingGradient
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.ExitToApp,
                                contentDescription = "Log Out",
                                tint = FoodOnboardingGradient
                            )
                        }
                    }
                )

            }
        ) { padding ->
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(padding)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ConstraintLayout() {
                    val (topImg, profile) = createRefs()
                    Box(
                        modifier = Modifier
                            .size(height = 200.dp, width = 430.dp)
                            .constrainAs(topImg) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.background_profile),
                            contentDescription = "Food",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent),
                            contentAlignment = Alignment.BottomStart
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                Color(0x00FFFFFF),
                                                Color.White
                                            ),
                                            startY = 200f
                                        )
                                    )
                            )
                        }
                    }
                    Image(
                        painter = painterResource(id = R.drawable.sample_avatar),
                        contentDescription = "Avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .border(
                                width = 4.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                            .clip(CircleShape)
                            .constrainAs(profile) {
                                top.linkTo(topImg.bottom)
                                bottom.linkTo(topImg.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    )
                }
                Text(
                    text = "John Dou",
                    fontFamily = ReemKufi,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
                )
                Text(
                    text = "johndou@gmail.com",
                    fontFamily = ReemKufi,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 4.dp, start = 16.dp, end = 16.dp),
                    color = Color.LightGray
                )
                Text(
                    text = "Male · 24 years",
                    fontFamily = ReemKufi,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 4.dp, start = 16.dp, end = 16.dp),
                    color = Color.LightGray
                )
                RoundCardWithButtons(Icons.Default.Notifications, Icons.Default.Build,
                    "Notifications",
                    "Notifications settings")
                RoundCardWithButtons(Icons.Default.List, Icons.Default.Send,
                    "History",
                    "Feedback"
                    )
            }
        }
    }
}

@Composable
fun RoundCardWithButtons(imageForButton1 : ImageVector,
                         imageForButton2 : ImageVector,
                         textForButton1 : String,
                         textForButton2: String
                         ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Transparent),
        colors = CardDefaults.cardColors(FoodOnboardingBackground),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Button(
                onClick = {
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(FoodOnboardingBackground)
            ) {
                Row(
                    modifier = Modifier.background(Color.Transparent)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = imageForButton1,
                        contentDescription = null,
                        modifier = Modifier.padding(4.dp),
                    )
                    Text(
                        text = textForButton1,
                        fontFamily = ReemKufi,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
            DividerComponentForProfile()
            Button(
                onClick = {
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(FoodOnboardingBackground)
            ) {
                Row(
                    modifier = Modifier.background(Color.Transparent)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = imageForButton2,
                        contentDescription = null,
                        modifier = Modifier.padding(4.dp),
                    )
                    Text(
                        text = textForButton2,
                        fontFamily = ReemKufi,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun DividerComponentForProfile() {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            color = Color.White,
            thickness = 1.dp
        )

    }
}
