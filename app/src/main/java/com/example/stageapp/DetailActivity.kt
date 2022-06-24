package com.example.stageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {
    lateinit var name:TextView
    lateinit var email: TextView
    lateinit var phone:TextView
    lateinit var street:TextView
    lateinit var suite:TextView
    lateinit var geo: TextView
    lateinit var zipcode:TextView
    lateinit var address:TextView
    lateinit var website: TextView
    lateinit var city: TextView
    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deatail_main)
        toolbar= findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="User Detail Info"

        var gName=intent.getStringExtra("Name")
        var gemail=intent.getStringExtra("Email")
        var gPhone=intent.getStringExtra("Phone")
        var gWebsite=intent.getStringExtra("Website")
        var gAddressSuite=intent.getStringExtra("Address_Suite")
        var gAddressCity=intent.getStringExtra("Address_City")
        var gAddressZipcode=intent.getStringExtra("Address_Zipcode")
        var gAddressStreet=intent.getStringExtra("Address_Street")
        name= findViewById(R.id.detail_name)
        email= findViewById(R.id.detail_email)
        phone= findViewById(R.id.detail_phone)
        website= findViewById(R.id.detail_website)
        suite= findViewById(R.id.address_suite)
        zipcode= findViewById(R.id.address_zipcode)
        street= findViewById(R.id.address_street)
        city= findViewById(R.id.address_city)


        name.text= gName
        email.text= gemail
        phone.text= gPhone
        website.text= gWebsite
        street.text=gAddressStreet
        city.text=gAddressCity
        suite.text= gAddressSuite
        zipcode.text=gAddressZipcode
    }
}