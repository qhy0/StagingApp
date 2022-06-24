package com.example.stageapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GeoInfo(
    @SerializedName("lat")
    val lat:String,
    @SerializedName("lng")
    val lng:String,
)
