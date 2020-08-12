package com.example.shaadiassignment.retrofit

import com.example.shaadiassignment.model_classes.Example
import io.reactivex.Observable
import retrofit2.http.GET

interface GetData {
    @GET("/api/?results=10")
    fun getPerson():Observable<Example>
}
