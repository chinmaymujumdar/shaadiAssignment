package com.example.shaadiassignment.model_classes

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Picture:BaseObservable() {

    @SerializedName("large")
    @Expose
    var large: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("medium")
    @Expose
    var medium: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null
        @Bindable get() {
            return field
        }

}
