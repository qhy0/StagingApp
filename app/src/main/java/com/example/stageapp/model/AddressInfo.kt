package com.example.stageapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AddressInfo(
    @SerializedName("street")
    val street:String,
    @SerializedName("suite")
    val suite:String,
    @SerializedName("city")
    val city:String,
    @SerializedName("zipcode")
    val zipcode:String,
    @SerializedName("geo")
    val address:GeoInfo,
)
