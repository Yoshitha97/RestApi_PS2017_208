package com.example.restapi_ps_2017_208.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitAPI {

    @GET("posts")
    fun getPost() : Call<List<Post>>

    @GET("comments")
    fun getComments() : Call<List<Comment>>

    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create() : RetrofitAPI {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitAPI::class.java)

        }
    }
}