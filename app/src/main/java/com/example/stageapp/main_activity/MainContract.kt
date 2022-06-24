package com.example.stageapp.main_activity

import com.example.stageapp.model.UserInfo

class MainContract {

    internal interface presenter {
        fun onDestroy()
        fun onRefreshButtonClick()
        fun requestDataFromServer(isConnected:Boolean)

    }


    interface MainView {
        fun showProgress()
        fun hideProgress()
        fun setDataToRecyclerView(userArrayList: List<UserInfo>)
        fun onResponseFailure(throwable: Throwable?)
        fun showStoreData()
    }


    interface GetUserInfoIntractor {
        interface OnFinishedListener {
            fun onFinished(userArrayList: List<UserInfo>)
            fun onFailure(t: Throwable?)
        }

        fun getUserInfoArrayList(onFinishedListener: OnFinishedListener?)
    }
}