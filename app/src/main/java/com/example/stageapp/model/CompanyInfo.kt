package com.example.stageapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CompanyInfo(
    @SerializedName("name")
    val name:String,
    @SerializedName("catchPhrase")
    val catchPhrase:String,
    @SerializedName("bs")
    val bs:String,
)
