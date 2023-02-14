package com.example.photogalleryapp

import android.R
import android.app.ProgressDialog
import android.content.Context
import org.json.JSONArray


class Utils {

    companion object{
        private var progress: ProgressDialog? = null
        fun parseData(jsonArray: JSONArray, saveInFile:Boolean):List<PictureDetails>{
            var list:MutableList<PictureDetails> = ArrayList()
            (0 until jsonArray.length()).forEach {
                val jsonObject = jsonArray.getJSONObject(it)
                val picture:PictureDetails = PictureDetails(
                    jsonObject.optString("copyright", ""), jsonObject.optString("date", ""),
                    jsonObject.optString("explanation", ""), jsonObject.optString("hdurl", ""),
                    jsonObject.optString("media_type", ""), jsonObject.optString("service_version", ""),
                    jsonObject.optString("title", ""), jsonObject.optString("url", "")
                )
                list.add(picture)
            }
            if(saveInFile){
                saveDataInFile(jsonArray)
            }
            return list
        }


        fun saveDataInFile(jsonArray: JSONArray){

        }

        /*fun parseDataFromFile():List<PictureDetails>{
            var list:MutableList<PictureDetails> = ArrayList()
            (0 until jsonArray.length()).forEach {
                val jsonObject = jsonArray.getJSONObject(it)
                val picture:PictureDetails = PictureDetails(
                    jsonObject.optString("copyright", ""), jsonObject.optString("date", ""),
                    jsonObject.optString("explanation", ""), jsonObject.optString("hdurl", ""),
                    jsonObject.optString("media_type", ""), jsonObject.optString("service_version", ""),
                    jsonObject.optString("title", ""), jsonObject.optString("url", "")
                )
                list.add(picture)

            }

            return list
        }*/


        fun showLoadingDialog(context:Context) {
            if (progress == null) {
                progress = ProgressDialog(context)
                progress!!.setTitle("Loading")
                progress!!.setMessage("Wait while loading...")
            }
            progress!!.show()
        }

        fun dismissLoadingDialog() {
            if (progress != null && progress!!.isShowing) {
                progress!!.dismiss()
            }
        }


    }
}


