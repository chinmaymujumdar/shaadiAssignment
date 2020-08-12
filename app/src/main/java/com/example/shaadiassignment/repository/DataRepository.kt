package com.example.shaadiassignment.repository

import com.example.shaadiassignment.model_classes.Example
import com.example.shaadiassignment.retrofit.GetData
import com.example.shaadiassignment.retrofit.RetrofitInstance
import io.reactivex.Observable

class DataRepository {

    var api: GetData?=null

    init {
        api= RetrofitInstance.getInstance()
    }

    fun getData():Observable<Example>?{
        return api?.getPerson()
    }

}