package com.example.photogalleryapp

import org.json.JSONArray
import org.json.JSONObject

class Utils {

    companion object{
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

    }
}


