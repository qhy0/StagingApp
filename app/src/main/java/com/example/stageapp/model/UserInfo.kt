package com.example.stageapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserInfo(
@SerializedName("id")
val id:Int,
@SerializedName("name")
val name:String,
@SerializedName("username")

val username:String,
@SerializedName("email")
val email:String,

@SerializedName("address")
val address:AddressInfo,

@SerializedName("phone")
val phone:String,

@SerializedName("website")
val website:String,

@SerializedName("company")
val company:CompanyInfo,

)
