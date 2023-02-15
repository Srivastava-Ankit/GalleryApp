package com.example.photogalleryapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photogalleryapp.overview.PictureListState
import com.example.photogalleryapp.result.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class PictureViewModel@Inject constructor(
    private val getImagesUseCase: GetImagesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(PictureListState())
    val state: State<PictureListState> = _state

    init {
        getPictures()
    }

    private fun getPictures() {
        getImagesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PictureListState(images = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PictureListState(error = result.message ?: "An error occurred")
                }
                is Resource.Loading -> {
                    _state.value = PictureListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}

