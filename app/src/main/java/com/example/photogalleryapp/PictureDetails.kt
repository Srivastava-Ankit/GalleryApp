package com.example.photogalleryapp


class PictureDetails {
     var copyright:String
     var date:String
     var explanation:String
     var hdurl:String
     var media_type:String
     var service_version:String
     var title:String
     var url:String

    constructor(
        copyright: String,
        date: String,
        explanation: String,
        hdurl: String,
        media_type: String,
        service_version: String,
        title: String,
        url: String
    ) {
        this.copyright = copyright
        this.date = date
        this.explanation = explanation
        this.hdurl = hdurl
        this.media_type = media_type
        this.service_version = service_version
        this.title = title
        this.url = url
    }
}