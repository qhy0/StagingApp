package com.example.stageapp.service

import com.example.stageapp.model.UserInfo
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Header


interface ApiServices {
    @GET("/users")
    fun getUserInfo(): Call<List<UserInfo>>
}