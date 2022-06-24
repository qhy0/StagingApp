package com.example.stageapp.main_activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stageapp.DetailActivity
import com.example.stageapp.R
import com.example.stageapp.adapter.UserRecyclerAdapter
import com.example.stageapp.model.UserInfo
import com.example.stageapp.storedata.StoreUserInfo
import kotlinx.android.synthetic.main.content_main.*

class ListMainActivity : AppCompatActivity(),MainContract.MainView {
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var storeUserInfo: StoreUserInfo
    lateinit var noData:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_main)
        initializeToolbarAndRecyclerView()
        storeUserInfo= StoreUserInfo(this)
        progressBar= findViewById(R.id.progress_circular)
        noData= findViewById(R.id.no_data_show)
        var isConnected= false

        isConnected = isNetWorkConnected()
        var presenter= MainPresenter(this,GetUserIntractorIpl())
        presenter.requestDataFromServer(isConnected)
    }
    private fun isNetWorkConnected():Boolean{
        var cm= getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return (cm.activeNetworkInfo!=null && cm.activeNetworkInfo!!.isConnected)
    }

    private fun initializeToolbarAndRecyclerView() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        recyclerView = findViewById(R.id.userinfo_recyclerview)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }
    private val recyclerItemClickListener: RecyclerItemClickListener =
        object : RecyclerItemClickListener {
            override fun onItemClick(userinfo: UserInfo) {
                Intent(this@ListMainActivity,DetailActivity::class.java).apply {
                    var address= userinfo.address
                    this.putExtra("Address_City",address.city)
                    this.putExtra("Address_Street",address.street)
                    this.putExtra("Address_Suite",address.suite)
                    this.putExtra("Address_Zipcode",address.zipcode)
                    this.putExtra("Name",userinfo.name)
                    this.putExtra("Email",userinfo.email)
                    this.putExtra("Phone",userinfo.phone)
                    this.putExtra("Website",userinfo.website)
                    startActivity(this)
                }
            }
        }

    override fun showProgress() {
        progressBar.visibility=View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility= View.INVISIBLE
    }

    override fun setDataToRecyclerView(userList: List<UserInfo>) {
        storeUserInfo.saveUsers(userList)
        recyclerView.visibility= View.VISIBLE
        var adapter= UserRecyclerAdapter(userList,recyclerItemClickListener)
        recyclerView.adapter= adapter
    }

    override fun showStoreData() {
        var userlist= storeUserInfo.getUsers()
        if (userlist.size>0){
            recyclerView.visibility= View.VISIBLE
            var adapter= UserRecyclerAdapter(userlist,recyclerItemClickListener)
            recyclerView.adapter= adapter
        }else{
            recyclerView.visibility= View.INVISIBLE
            noData.visibility= View.VISIBLE
        }


    }

    override fun onResponseFailure(throwable: Throwable?) {
            Toast.makeText(
                this,
                "Something went wrong...Error message: " + throwable!!.message,
                Toast.LENGTH_LONG
            ).show()

    }
}