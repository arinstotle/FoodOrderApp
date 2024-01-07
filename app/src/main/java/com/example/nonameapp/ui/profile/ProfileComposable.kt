package com.example.nonameapp.ui.profile

import com.example.nonameapp.R
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.nonameapp.navigation.Screen
import com.example.nonameapp.ui.signUp.tinyComposableElements.ButtonComponent
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
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                    actions = {
                        Row() {
                            Button(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                onClick = { /*TODO*/ },
                                contentPadding = PaddingValues(0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .align(Alignment.CenterVertically),
                                    imageVector = ImageVector.vectorResource(R.drawable.edit),
                                    contentDescription = "Edit Profile",
                                    tint = Teal
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                contentPadding = PaddingValues(0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                )
                            ) {
                                Icon(
                                    modifier = Modifier.size(25.dp),
                                    imageVector = ImageVector.vectorResource(R.drawable.export_arrow_right),
                                    contentDescription = "Log Out",
                                    tint = Teal
                                )
                            }
                        }
                    }
                )

            }
        ) { padding ->
            val brush = remember {
                Brush.sweepGradient(
                    listOf(
                        Color.Transparent,
                        OrangeD8,
                        RedD8,
                        Color.Transparent
                    )
                )
            }
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .scrollable(ScrollState(0), orientation = Orientation.Vertical)
            ) {
                val contrast = 0.4f
                val brightness = -20f
                val colorMatrix = floatArrayOf(
                    contrast, 0f, 0f, 0f, brightness,
                    0f, contrast, 0f, 0f, brightness,
                    0f, 0f, contrast, 0f, brightness,
                    0f, 0f, 0f, 1f, 0f
                )
                Image(
                    contentDescription = "Food",
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.sample_avatar),
                    modifier = Modifier.fillMaxSize(),
                    colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
                )
                Column(modifier = Modifier.align(Alignment.Center)) {
                    Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Image(
                            painter = painterResource(id = R.drawable.sample_avatar),
                            contentDescription = "Avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .border(
                                    BorderStroke(1.dp, brush = brush),
                                    shape = CircleShape
                                )
                                .clip(CircleShape)
                        )
                        Box(modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .background(OrangeD8, RoundedCornerShape(10.dp))
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 6.dp, end = 6.dp, top = 2.dp, bottom = 2.dp),
                                fontFamily = ReemKufi,
                                fontSize = 10.sp,
                                text = "PRO"
                            )
                        }
                    }
                    Text(
                        text = "John Dou",
                        fontFamily = ReemKufi,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Teal
                    )
                    Text(
                        text = "johndou@gmail.com",
                        fontFamily = ReemKufi,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(top = 2.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Teal
                    )
                    Text(
                        text = "Male · 24 years",
                        fontFamily = ReemKufi,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 2.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Teal
                    )
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)) {
                    RoundCardWithButtons(
                        Icons.Default.Notifications, Icons.Default.Build,
                        "Notifications",
                        "Notifications settings"
                    )
                    RoundCardWithButtons(
                        Icons.Default.List, Icons.Default.Send,
                        "History",
                        "Feedback"
                    )
                }
                    Row() {
                        Text(
                            text = "My coupons: 3",
                            fontFamily = ReemKufi,
                            color = Teal,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left,
                            modifier = Modifier.padding(16.dp)
                        )
                        ButtonComponent(text = "See all!") {

                        }
                    }
                }
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
            .background(Color.Transparent)
            .clip(RoundedCornerShape(20.dp))
        ,
        colors = CardDefaults.cardColors(Black1_28),
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
                colors = ButtonDefaults.buttonColors(Black1_28)
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.background( brush =
                    Brush.horizontalGradient(listOf(RedD8, OrangeD8)),
                        RoundedCornerShape(8.dp))) {
                        Icon(
                            imageVector = imageForButton1,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(30.dp),
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = textForButton1,
                        fontFamily = ReemKufi,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
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
                colors = ButtonDefaults.buttonColors(Black1_28)
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.background(
                        brush = Brush.horizontalGradient(listOf(RedD8, OrangeD8)),
                        RoundedCornerShape(8.dp))) {
                        Icon(
                            imageVector = imageForButton2,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(30.dp),
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = textForButton2,
                        fontFamily = ReemKufi,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
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
            color = Teal,
            thickness = 0.5.dp
        )

    }
}
