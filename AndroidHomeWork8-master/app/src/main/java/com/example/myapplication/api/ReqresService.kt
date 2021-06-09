package com.example.myapplication.api

import com.example.myapplication.api.dto.ReqresData
import com.example.myapplication.api.dto.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*
 *  Created by Nikoloz Katsitadze on 27.05.21
 */

interface ReqresService {

    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<ReqresData<List<User>>>

    @GET("users/{userId}")
    fun getUserInfo(@Path("userId") userId: Long): Call<ReqresData<User>>

}