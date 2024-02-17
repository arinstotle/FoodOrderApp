package com.example.nonameapp.ui.reservation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nonameapp.R
import com.example.nonameapp.ui.reservation.components.FieldComponent
import com.example.nonameapp.ui.reservation.components.ReservationDataSource
import com.example.nonameapp.ui.reservation.components.ClientTableComponent
import com.example.nonameapp.ui.reservation.components.ClientTableShimmerComponent
import com.example.nonameapp.viewModels.ReservationViewModel


@Composable
fun ReservationComposable(
    navController: NavController,
    viewModel: ReservationViewModel
){
    val listOfTables by viewModel.listOfTables.collectAsState(initial = listOf())
    
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            val columns = 18f
            val rows = 28f

            val tileWidth = this@BoxWithConstraints.maxWidth / columns
            val tileHeight = this@BoxWithConstraints.maxHeight / rows

//            Log.i("ReservationComposable", "tileWidth = $tileWidth | tileHeight = $tileHeight")

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.tables_blue_empty),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            FieldComponent(
                rows = rows.toInt(),
                columns = columns.toInt(),
                tileWidth = tileWidth,
                tileHeight = tileHeight,
                tileModifier = Modifier
                    .border(width = 0.1.dp, color = MaterialTheme.colorScheme.primary)
            )

            val alphaAnimated: Float by rememberInfiniteTransition(label = "anim1").animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 2000,
                        easing = LinearEasing,
                        delayMillis = 500
                    ),
                    repeatMode = RepeatMode.Reverse,
                ), label = "anim1"
            )

            if(listOfTables == null){
                for(emptyTableUI in ReservationDataSource.listOfTables){
                    ClientTableShimmerComponent(
                        tableUIModel = emptyTableUI,
                        tileHeight = tileHeight,
                        tileWidth = tileWidth
                    )
                }
            }
            else{
                for(tableUI in listOfTables!!){
                    ClientTableComponent(
                        tileHeight = tileHeight,
                        tileWidth = tileWidth,
                        tableUIModel = tableUI,
                        alphaAnimated = alphaAnimated,
                        onClick = {
                            viewModel.performReserveTable(tableUI.id)
                        }
                    )
                }
            }

        }
    }
}



//@Preview(device = "spec:width=1080px,height=2000px", showSystemUi = true)
//@Composable
//fun Mi9TReservationPreview(){
//    ReservationComposable()
//}
//
//@Preview(device = "spec:width=768px,height=1366px", showSystemUi = true)
//@Composable
//fun ReservationPreview2(){
//    ReservationComposable()
//}
//
//@Preview(device = "spec:width=900px,height=1440px", showSystemUi = true)
//@Composable
//fun ReservationPreview3(){
//    ReservationComposable()
//}