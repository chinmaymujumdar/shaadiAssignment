package com.example.shaadiassignment.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder


class RetrofitInstance {
    companion object{
        fun getInstance(): GetData {
            return Retrofit.Builder().baseUrl("https://randomuser.me")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(GetData::class.java)
        }
    }
}