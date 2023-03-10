package com.example.photogalleryapp.overview

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.photogalleryapp.PictureViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PictureGridScreen(navController:NavController, viewModel: PictureViewModel) {
    val state = viewModel.state.value
    when {
        state.error.isNotBlank() -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = state.error)
            }
        }
        state.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        else -> {
            LazyVerticalGrid(cells = GridCells.Adaptive(150.dp)) {
                itemsIndexed(state.images) { index, image ->
                    PictureItem(image, index, navController)
                }
            }
        }
    }
}