package com.example.shaadiassignment.model_classes

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location:BaseObservable() {

    @SerializedName("street")
    @Expose
    var street: Street? = null
        @Bindable get() {
            return field
        }
    @SerializedName("city")
    @Expose
    var city: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("state")
    @Expose
    var state: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("country")
    @Expose
    var country: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("postcode")
    @Expose
    var postcode: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("coordinates")
    @Expose
    var coordinates: Coordinates? = null
        @Bindable get() {
            return field
        }
    @SerializedName("timezone")
    @Expose
    var timezone: Timezone? = null
        @Bindable get() {
            return field
        }

}
