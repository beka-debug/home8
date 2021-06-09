package com.example.myapplication.api.dto

import com.google.gson.annotations.SerializedName

data class User(

    val id: Long?,

    val email: String?,

    @SerializedName("first_name")
    val firstName: String?,

    @SerializedName("last_name")
    val lastName: String?,

    val avatar: String?

)

data class UserHelper(
    val text : String?
)

data class ReqresData<T>(

    val page: Int?,

    val data: T?,

    val support : UserHelper?

)