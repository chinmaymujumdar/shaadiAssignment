package com.example.shaadiassignment.model_classes

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Name :BaseObservable(){

    @SerializedName("title")
    @Expose
    var title: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("first")
    @Expose
    var first: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("last")
    @Expose
    var last: String? = null
        @Bindable get() {
            return field
        }

}
