package com.example.stageapp.main_activity

import com.example.stageapp.model.UserInfo
import com.example.stageapp.retrofit.RetrofitInstance
import com.example.stageapp.service.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserIntractorIpl:MainContract.GetUserInfoIntractor {
    override fun getUserInfoArrayList(onFinishedListener: MainContract.GetUserInfoIntractor.OnFinishedListener?) {
        val service: ApiServices = RetrofitInstance().getRetrofitInstance().create(ApiServices::class.java)

        val call: Call<List<UserInfo>> = service.getUserInfo()
        call.enqueue(object : Callback<List<UserInfo>> {
            override fun onResponse(call: Call<List<UserInfo>>, response: Response<List<UserInfo>>) {
                val userinfoList= response.body() as List<UserInfo>

                onFinishedListener?.onFinished(userinfoList)
            }

            override fun onFailure(call: Call<List<UserInfo>>, t: Throwable) {
                onFinishedListener?.onFailure(t)
            }

        })
    }
}