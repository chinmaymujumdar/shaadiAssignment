package com.example.shaadiassignment.model_classes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Street {

    @SerializedName("number")
    @Expose
    var number: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}
