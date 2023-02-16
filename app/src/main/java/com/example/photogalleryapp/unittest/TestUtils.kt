package com.example.photogalleryapp.unittest

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.photogalleryapp.AppModule
import com.example.photogalleryapp.PictureViewModel
import com.example.photogalleryapp.model.PictureDetails


object TestUtils {

    suspend fun getPictureFromNetwork():List<PictureDetails>{
        val nasaApi = AppModule.provideNasaApi()
        val nasaRepository = AppModule.provideImageRepository(nasaApi)
        val list = nasaRepository.getImages()
        return list
    }

    @Composable
    fun getNetworkError():String{
        val viewModel:PictureViewModel = hiltViewModel()
        val state = viewModel.state
        return state.value.error
    }

}