package com.example.photogalleryapp

import androidx.lifecycle.ViewModel
import com.example.photogalleryapp.network.DataRepo

class PictureViewModel:ViewModel() {

    var dataRepo: DataRepo? = null
    var pictureDetailsList:MutableList<PictureDetails>? = null

    init {
        dataRepo = DataRepo.newInstance()
    }

    fun getAllPictureList():List<PictureDetails>?{
        pictureDetailsList = dataRepo!!.getAllPictureDetails() as MutableList<PictureDetails>?
        return pictureDetailsList
    }
}