package com.example.photogalleryapp.network

import com.example.photogalleryapp.model.PictureDetails
import retrofit2.http.GET

interface NasaApi {

    @GET("/obvious/take-home-exercise-data/trunk/nasa-pictures.json")
    suspend fun getImages(): List<PictureDetails>
}