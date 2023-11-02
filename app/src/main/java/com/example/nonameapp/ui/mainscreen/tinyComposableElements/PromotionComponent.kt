package com.example.nonameapp.ui.mainscreen.tinyComposableElements

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nonameapp.Promotion
import com.example.nonameapp.R
import com.example.nonameapp.ui.theme.GrayColorWithAlpha
import com.example.nonameapp.ui.theme.ReemKufi

@Composable
fun PromotionListComponent(promotions: List<Promotion>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(promotions.size) { promotion ->
            Column(
                modifier = Modifier
                    .fillParentMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PromotionComponentItem(
                    promotionText = promotions[promotion].promotionTitle,
                    shortDescription = promotions[promotion].shortDescription,
                    picture = promotions[promotion].pictureId
                )
            }
        }
    }
}

@Composable
fun PromotionComponentItem(
    promotionText : String,
    shortDescription : String,
    picture : Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(GrayColorWithAlpha)
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Column(modifier = Modifier.weight(1f).padding(16.dp)) {
            Text(
                text = promotionText,
                fontFamily = ReemKufi,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = shortDescription,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.Light,
                color = Color.White,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Image(
            painter = painterResource(id = picture),
            contentDescription = "Picture",
            modifier = Modifier
                .padding(end = 10.dp, top = 10.dp, bottom = 10.dp)
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun ShimmerPromotionComponentItem(
    promotionText : String,
    shortDescription : String,
    picture : Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(GrayColorWithAlpha)
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        AnimatedWave()
        Column(modifier = Modifier.weight(1f).padding(16.dp)) {
            Text(
                text = promotionText,
                fontFamily = ReemKufi,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = shortDescription,
                fontFamily = ReemKufi,
                fontWeight = FontWeight.Light,
                color = Color.White,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Image(
            painter = painterResource(id = picture),
            contentDescription = "Picture",
            modifier = Modifier
                .padding(end = 10.dp, top = 10.dp, bottom = 10.dp)
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun AnimatedWave() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val animOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )
    Wave(animOffset)
}