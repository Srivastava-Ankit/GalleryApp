package com.example.photogalleryapp.network

import android.util.Log
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class Data {
    companion object{
        val TAG:String? = "Data"
        fun makeApiCallForPicture():JSONArray  {
            var url:String = "https://raw.githubusercontent.com/obvious/take-home-exercise-data/trunk/nasa-pictures.json"
            var text:String
            val connection = URL(url).openConnection() as HttpURLConnection
            try{
                connection.connect()
                text = connection.inputStream.reader().use { it.readText()}
            }finally {
               connection.disconnect()
            }
            Log.d(TAG, text)
            return JSONArray(text)
        }
    }
}



