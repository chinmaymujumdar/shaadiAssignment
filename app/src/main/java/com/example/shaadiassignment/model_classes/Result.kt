package com.example.shaadiassignment.model_classes

import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.shaadiassignment.viewmodel.PersonViewModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.shaadiassignment.room_database.Converter


@Entity
class Result: BaseObservable() {

    @SerializedName("gender")
    @Expose
    var gender: String? = null
        @Bindable get() {
            return field
        }
    @TypeConverters(Converter::class)
    @SerializedName("name")
    @Expose
    var name: Name? = null
        @Bindable get() {
            return field
        }
    @TypeConverters(Converter::class)
    @SerializedName("location")
    @Expose
    var location: Location? = null
        @Bindable get() {
            return field
        }
    @SerializedName("email")
    @Expose
    var email: String? = null
        @Bindable get() {
            return field
        }
    @TypeConverters(Converter::class)
    @SerializedName("login")
    @Expose
    var login: Login? = null
        @Bindable get() {
            return field
        }
    @TypeConverters(Converter::class)
    @SerializedName("dob")
    @Expose
    var dob: Dob? = null
        @Bindable get() {
            return field
        }
    @TypeConverters(Converter::class)
    @SerializedName("registered")
    @Expose
    var registered: Registered? = null
        @Bindable get() {
            return field
        }

    @PrimaryKey
    @NonNull
    @SerializedName("phone")
    @Expose
    var phone: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("cell")
    @Expose
    var cell: String? = null
        @Bindable get() {
            return field
        }
    @TypeConverters(Converter::class)
    @SerializedName("id")
    @Expose
    var id: Id? = null
        @Bindable get() {
            return field
        }
    @TypeConverters(Converter::class)
    @SerializedName("picture")
    @Expose
    var picture: Picture? = null
        @Bindable get() {
            return field
        }
    @SerializedName("nat")
    @Expose
    var nat: String? = null
        @Bindable get() {
            return field
        }
    @SerializedName("status")
    @Expose
    var status:String = "0"
        @Bindable get() {
            return field
        }

    companion object {
        @BindingAdapter(value = ["bind:url","bind:viewModel"], requireAll = false)
        @JvmStatic
        fun loadImage(imageView: ImageView, url:String, viewModel: PersonViewModel) {
            Glide.with(imageView.context).load(url).apply(RequestOptions.bitmapTransform( RoundedCorners(20))).skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView)
        }

        @BindingAdapter(value = ["bind:visibility"], requireAll = false)
        @JvmStatic
        fun visibility(view:Button,status:String){
            if (view.tag.equals("accept")){
                if (status.equals("2")){
                    view.visibility= View.GONE
                }else{
                    view.visibility= View.VISIBLE
                }
            }else{
                if (status.equals("1")){
                    view.visibility= View.GONE
                }else{
                    view.visibility= View.VISIBLE
                }
            }
        }
    }

}
