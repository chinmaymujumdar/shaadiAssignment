package com.example.shaadiassignment.room_database

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.shaadiassignment.model_classes.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {
    private val gson=Gson()

    @TypeConverter
    fun toHashString(map: HashMap<String,String>):String{
        return gson.toJson(map)
    }

    @TypeConverter
    fun toHashMap(json: String):HashMap<String,String>{
        val objectList:HashMap<String,String> = gson.fromJson(json, object : TypeToken<HashMap<String, String>>() {}.type)
        return objectList
    }

    @TypeConverter
    fun toNameString(name:Name):String{
        return gson.toJson(name)
    }

    @TypeConverter
    fun toStrinName(json: String):Name{
        return gson.fromJson<Name>(json,Name::class.java)
    }

    @TypeConverter
    fun toLocationString(name: Location):String{
        return gson.toJson(name)
    }

    @TypeConverter
    fun toStrinLocation(json: String):Location{
        return gson.fromJson<Location>(json,Location::class.java)
    }

    @TypeConverter
    fun toDobString(name: Dob):String{
        return gson.toJson(name)
    }

    @TypeConverter
    fun toStrinDob(json: String):Dob{
        return gson.fromJson<Dob>(json,Dob::class.java)
    }

    @TypeConverter
    fun toRegisteredString(name: Registered):String{
        return gson.toJson(name)
    }

    @TypeConverter
    fun toStrinRegistered(json: String):Registered{
        return gson.fromJson<Registered>(json,Registered::class.java)
    }

    @TypeConverter
    fun toLoginString(name: Login):String{
        return gson.toJson(name)
    }

    @TypeConverter
    fun toStrinLogin(json: String):Login{
        return gson.fromJson<Login>(json,Login::class.java)
    }

    @TypeConverter
    fun toIdString(name: Id):String{
        return gson.toJson(name)
    }

    @TypeConverter
    fun toStrinId(json: String):Id{
        return gson.fromJson<Id>(json,Id::class.java)
    }

    @TypeConverter
    fun toPictureString(name: Picture):String{
        return gson.toJson(name)
    }

    @TypeConverter
    fun toStrinPicture(json: String):Picture{
        return gson.fromJson<Picture>(json,Picture::class.java)
    }
}