package com.example.photogalleryapp


import com.example.photogalleryapp.model.Picture
import com.example.photogalleryapp.model.PictureDetails
import com.example.photogalleryapp.model.toPicture
import com.example.photogalleryapp.network.NasaRepository
import com.example.photogalleryapp.result.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: NasaRepository
) {
    operator fun invoke(): Flow<Resource<List<Picture>>> = flow {
        try {
            emit(Resource.Loading<List<Picture>>())
            val images = repository.getImages().map { it.toPicture() }
            emit(Resource.Success<List<Picture>>(images))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Picture>>("Network issue or Server is down"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Picture>>("Failed to connect to server \uD83D\uDE22"))
        }
    }
}