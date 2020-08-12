package com.example.shaadiassignment.repository

import android.content.Context
import com.example.shaadiassignment.model_classes.Result
import com.example.shaadiassignment.room_database.DBOperations

class OfflineRepository(var context:Context) {

    private var db:DBOperations?= null

    init {
        db= DBOperations(context)
    }

    public fun storeListToDB(list:List<Result>){
        db?.insertAll(list)
    }

    public fun deleteAll(){
        db?.deleteAll()
    }

    public fun getAllItem():List<Result>?{
        return db?.getAll()
    }

    public fun update(item:Result){
        db?.update(item)
    }
}