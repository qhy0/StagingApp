package com.example.stageapp.main_activity

import android.util.Log
import com.example.stageapp.main_activity.MainContract.MainView
import com.example.stageapp.main_activity.MainContract.presenter
import com.example.stageapp.model.UserInfo

class MainPresenter(
    private var mainView: MainView?,
    getUserIntractor: MainContract.GetUserInfoIntractor
) :
    presenter, MainContract.GetUserInfoIntractor.OnFinishedListener {
    private val getUserIntractor: MainContract.GetUserInfoIntractor = getUserIntractor
    override fun onDestroy() {
        mainView = null
    }


    override fun onRefreshButtonClick() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        //getUserIntractor.getUserInfoArrayList(this)
    }

    override fun requestDataFromServer(isConnected:Boolean) {
        if (isConnected){
            onRefreshButtonClick()
            getUserIntractor.getUserInfoArrayList(this)
        }else{
            mainView!!.showStoreData()
        }

    }

    override fun onFinished(userList: List<UserInfo>) {
        if (mainView != null) {
            mainView!!.setDataToRecyclerView(userList)
            mainView!!.hideProgress()
        }     }

   override fun onFailure(t: Throwable?) {
        if (mainView != null) {
            Log.d("ErrorMessage",t.toString())
            mainView!!.onResponseFailure(t)
            mainView!!.hideProgress()
        }
    }


}