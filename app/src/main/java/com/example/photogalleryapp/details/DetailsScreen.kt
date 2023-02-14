package com.example.photogalleryapp.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.photogalleryapp.PictureDetails
import com.skydoves.landscapist.glide.GlideImage
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun DetailsScreen(
    index: String,
    navController: NavController,
    navigationIcon: @Composable() (() -> Unit)?,
    pictureDetails: List<PictureDetails>
) {
    val picture:MutableState<PictureDetails> = mutableStateOf( pictureDetails[index.toInt()])
    var currentIndex:MutableState<Int> = mutableStateOf(index.toInt())

   Scaffold(
       topBar = {
           TopAppBar(title = { Text(picture.value.title) }, navigationIcon = navigationIcon)
       },
        content = {

            // Creating a Column Layout
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                val mLocalContext = LocalContext.current
                val leftSwipe = SwipeAction (
                    icon = {},
                    background = Color.Transparent,
                    isUndo = true,
                    onSwipe = {
                        if(currentIndex.value!= 0){
                        currentIndex.value -= 1
                        picture.value =  pictureDetails[currentIndex.value]
                    }}
                )

                val rightSwipe = SwipeAction(
                    icon = {},
                    background = Color.Transparent,
                    isUndo = true,
                    onSwipe = {
                        if(currentIndex.value != pictureDetails.size-1){
                            currentIndex.value += 1
                            picture.value =  pictureDetails[currentIndex.value]
                    }}
                )

                SwipeableActionsBox(startActions = listOf(leftSwipe), endActions = listOf(rightSwipe)) {
                    GlideImage(
                        imageModel = { picture.value.url },
                        modifier = Modifier.fillMaxWidth().fillMaxHeight()
                    )
                }
            }
        }
    )

}



