package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.api.dto.ReqresData
import com.example.myapplication.api.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val photo = findViewById<ImageView>(R.id.detailsImage)
        val name = findViewById<TextView>(R.id.detailsName)
        val surname = findViewById<TextView>(R.id.detailsLastName)
        val text = findViewById<TextView>(R.id.detailsText)

        val userId = intent.getLongExtra("id",1)

        RetrofitClient.reqResApi.getUserInfo(userId).enqueue(object : Callback<ReqresData<User>> {
            override fun onResponse(
                call: Call<ReqresData<User>>,
                response: Response<ReqresData<User>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    Glide.with(this@DetailsActivity)
                        .load(response.body()?.data?.avatar)
                        .centerCrop()
                        .into(photo)
                    name.text = response.body()?.data?.firstName
                    surname.text = response.body()?.data?.lastName
                    text.text = response.body()?.support?.text
                }
            }

            override fun onFailure(call: Call<ReqresData<User>>, t: Throwable) {

            }

        })
    }
}