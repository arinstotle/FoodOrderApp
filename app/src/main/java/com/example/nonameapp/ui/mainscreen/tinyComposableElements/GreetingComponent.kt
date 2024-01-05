package com.example.nonameapp.ui.mainscreen.tinyComposableElements

import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.Black33
import com.example.nonameapp.ui.theme.OrangeD8
import com.example.nonameapp.ui.theme.ReemKufi
import com.example.nonameapp.ui.theme.Teal
import com.example.nonameapp.ui.theme.TextGray

@Preview
@Composable
fun GreetingSection(
    name: String = "John",
    imageResource: Int = R.drawable.food_onboarding,
    restaurantAddress: String = "Vvedenskiy street • 5A",
    ifNeedShowAnimation: Boolean = true,
    geoOpenAction: () -> Unit = {},
    carteOpenAction: () -> Unit = {},
    avatarOpenAction:() -> Unit = {},
    searchOpenAction: () -> Unit = {}
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 15.dp,
                top = 15.dp,
                bottom = 15.dp
            )
            .background(
                Black33,
            )
    ) {
        Column {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black33)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.geo_alt_icon),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = TextGray
                    )
                    Text(
                        text = restaurantAddress,
                        Modifier.padding(start = 8.dp, end = 8.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = ReemKufi,
                        color = TextGray
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_bottom),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {

                            }
                            .size(16.dp),
                        tint = TextGray
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Black33
                    )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .background(
                            Black33
                        )
                ) {
                    Image(
                        painter = painterResource(R.drawable.sample_avatar),
                        contentDescription = "avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        "Hello, $name!",
                        Modifier.padding(top = 4.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = ReemKufi,
                        color = OrangeD8
                    )
                    Text(
                        text = "Enjoy your meal!",
                        color = Teal,
                        fontFamily = ReemKufi
                    )
                }
                Column(modifier = Modifier.padding(8.dp)) {
                    CustomIconButton(infiniteTransition = infiniteTransition,
                        ifNeedShowAnimation)
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.search),
                            contentDescription = "SearchButton",
                            tint = Teal,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomIconButton(infiniteTransition: InfiniteTransition,
                     ifNeedShowAnimation: Boolean) {
    val position by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 20f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse), label = ""
    )
    BadgedBox(
        modifier = Modifier
            .size(40.dp)
            .offset(y = if (ifNeedShowAnimation)
                position.dp else 0.dp),
        badge = { BadgeContent(number = 1) }) {
        Image(
            painter = painterResource(R.drawable.cart_icon_main_screen),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
    if (ifNeedShowAnimation) {
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeContent(number: Int) {
    Badge(
        content = { Text(text = number.toString()) },
        modifier = Modifier.size(16.dp)
    )
}