package com.example.photogalleryapp

import androidx.lifecycle.ViewModel

class PictureViewModel:ViewModel() {

    var dataRepo:DataRepo? = null
    var pictureDetailsList:List<PictureDetails>? = null

    init {
        dataRepo = DataRepo.newInstance()
    }

    fun getAllPictureList():List<PictureDetails>?{
        pictureDetailsList = dataRepo!!.getAllPictureDetails()
        return pictureDetailsList
    }
}