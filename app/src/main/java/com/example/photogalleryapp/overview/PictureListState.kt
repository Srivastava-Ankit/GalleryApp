package com.example.photogalleryapp.overview

import com.example.photogalleryapp.model.Picture


data class PictureListState(
    val isLoading: Boolean = false,
    val images: List<Picture> = emptyList(),
    val error: String = ""
)