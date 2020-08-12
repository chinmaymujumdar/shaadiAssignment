package com.example.shaadiassignment.model_classes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Example {

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
    @SerializedName("info")
    @Expose
    var info: Info? = null

}
