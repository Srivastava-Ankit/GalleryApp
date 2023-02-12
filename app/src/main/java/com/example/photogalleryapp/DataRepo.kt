package com.example.photogalleryapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray

class DataRepo {
    val TAG:String? = "DataRepo"
    companion object{
        var dataRepo:DataRepo? = null
        var pictureDetailsList: List<PictureDetails>? = null

        fun newInstance():DataRepo{
            if (dataRepo == null){
                dataRepo = DataRepo()
            }
            return dataRepo as DataRepo
        }
    }

    fun getAllPictureDetails():List<PictureDetails>?{
        val response:JSONArray = Data.makeApiCallForPicture()
        if(response != null){
            pictureDetailsList = Utils.parseData(response, true)
            return pictureDetailsList
        }
        return null
    }

}