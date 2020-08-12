package com.example.shaadiassignment.retrofit

interface APICallback<T> {
    fun onSuccess(t:T)
    fun onError(e: Throwable)
}