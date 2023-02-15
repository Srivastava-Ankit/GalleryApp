package com.example.photogalleryapp.network


import com.example.photogalleryapp.model.PictureDetails
import javax.inject.Inject

class NasaRepositoryImpl @Inject constructor(
    private val api: NasaApi
) : NasaRepository {
    override suspend fun getImages(): List<PictureDetails> {
        return api.getImages()
    }
}