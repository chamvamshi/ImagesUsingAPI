package com.example.imagesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImageScreenActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter : MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_screen)

        recyclerView = findViewById(R.id.recyclerview)
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getImagesdata()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        myAdapter = MyAdapter(this@ImageScreenActivity, responseBody)
                        recyclerView.adapter = myAdapter
                        recyclerView.layoutManager = LinearLayoutManager(this@ImageScreenActivity)
                    } else {
                        // Handle empty response body
                        // For example, show an empty state message
                    }
                } else {
                    // Handle unsuccessful response
                    val errorBody = response.errorBody()
                    if (errorBody != null) {
                        val errorString = errorBody.string()

                    } else {
                        Log.d("TAG", "onResponse: " +errorBody)
                    }
                }
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("abcd", "onFailure: "+t.message)
            }
        })


    }
}


