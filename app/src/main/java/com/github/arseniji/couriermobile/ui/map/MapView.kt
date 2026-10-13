package com.github.arseniji.couriermobile.ui.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.github.arseniji.couriermobile.R

@Composable
fun MapView(){
    Image(
        painter = painterResource(R.drawable.map),
        contentDescription = "Карта",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}