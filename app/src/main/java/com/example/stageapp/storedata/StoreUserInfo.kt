package com.example.stageapp.storedata

import android.content.Context
import com.example.stageapp.model.UserInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StoreUserInfo(var context: Context) {
    private val prefName = context.packageName
    private val saveUserInfo="Users"
     fun saveUsers(list: List<UserInfo>) {
        val pref= context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        val edictor= pref.edit()
        edictor.putString(saveUserInfo, Gson().toJson(list))
        edictor.apply()
    }

     fun getUsers(): ArrayList<UserInfo> {
        val emptyList= Gson().toJson(ArrayList<UserInfo>())
        val sharePreferences= context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        return Gson().fromJson(
            sharePreferences.getString(saveUserInfo, emptyList),
            object : TypeToken<ArrayList<UserInfo>>() {
            }.type
        )
    }

     fun removeAssetViewingMinutes() {
        val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.remove(saveUserInfo)
        editor.apply()
    }
}