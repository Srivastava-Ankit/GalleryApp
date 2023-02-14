
package com.example.photogalleryapp.overview


import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.photogalleryapp.PictureDetails
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage


@ExperimentalFoundationApi
@Composable
fun GridScreen(navController: NavHostController, pictureDetails: List<PictureDetails>) {
    LazyVerticalGrid(columns =  GridCells.Fixed(2) , content = {
        itemsIndexed(pictureDetails) { index, picture ->
            Row{
                ItemLayout(picture, index, navController)
            }
        }
    })
}
@Composable
fun ItemLayout(
    pictureDetails: PictureDetails,
    index: Int,
    navController: NavHostController
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("details/$index")
            }
    ) {
        GlideImage(
            imageModel = { pictureDetails.url },
            imageOptions = ImageOptions(requestSize = IntSize(800, 600)),
        )
        Text(
            text = pictureDetails.title,
            color = Color.Black,
            fontSize = 10.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}



