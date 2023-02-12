package com.example.photogalleryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PictureGridScreen : AppCompatActivity() {
    val TAG:String? = "PictureGridScreen"
    var pictureDetailsList:List<PictureDetails> ?= null
    var pictureViewModel:PictureViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pictureViewModel = PictureViewModel()
        GlobalScope.launch(Dispatchers.IO) {
            pictureDetailsList = pictureViewModel!!.getAllPictureList()
            Log.d(TAG , pictureDetailsList!!.size.toString())
        }


    }
}