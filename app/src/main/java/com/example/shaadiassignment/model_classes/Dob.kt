package com.example.shaadiassignment.model_classes

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Dob :BaseObservable(){

    @SerializedName("date")
    @Expose
    var date: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("age")
    @Expose
    var age: String? = null
        @Bindable get() {
            return field
        }

}
