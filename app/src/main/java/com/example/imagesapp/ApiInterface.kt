package com.example.imagesapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    fun getImagesdata() : Call<MyData>
}