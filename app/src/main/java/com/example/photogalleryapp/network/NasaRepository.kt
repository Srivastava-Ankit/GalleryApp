package com.example.photogalleryapp.network

import com.example.photogalleryapp.model.PictureDetails

interface NasaRepository {
    suspend fun getImages(): List<PictureDetails>
}