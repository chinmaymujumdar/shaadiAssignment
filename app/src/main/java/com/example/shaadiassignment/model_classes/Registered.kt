package com.example.shaadiassignment.model_classes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Registered {

    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("age")
    @Expose
    var age: String? = null

}
