package com.example.photogalleryapp.model


data class PictureDetails (
     var copyright:String,
     var date:String,
     var explanation:String,
     var hdurl:String,
     var media_type:String,
     var service_version:String,
     var title:String,
     var url:String
     )


fun PictureDetails.toPicture(): Picture {
    return Picture(
        url = url,
        explanation = explanation,
        hdurl= hdurl,
        title = title
    )
}