package com.example.shaadiassignment.room_database

import android.content.Context
import android.os.AsyncTask
import com.example.shaadiassignment.model_classes.Result

class DBOperations(context: Context) {

    private var db:PersonDatabase?=null

    init {
        db= PersonDatabase.getInstance(context)
    }

    public fun insertAll(list:List<Result>){
        val insertAsync=InsertAllPerson(db!!)
        insertAsync.execute(list)
    }

    public fun deleteAll(){
        val deleteAsync=DeleteAll(db!!)
        deleteAsync.execute()
    }

    public fun update(item:Result){
        val updateAsync=Update(db!!)
        updateAsync.execute(item)
    }

    public fun getAll():List<Result>{
        val getAsync=GetAllItems(db!!)
        return getAsync.execute().get()
    }

    private class InsertAllPerson(var db:PersonDatabase):AsyncTask<List<Result>,Unit,Unit>(){
        override fun doInBackground(vararg p0: List<Result>?) {
            db.itemDao().insertAllItems(p0[0])
        }
    }

    private class DeleteAll(var db:PersonDatabase):AsyncTask<Unit,Unit,Unit>(){
        override fun doInBackground(vararg p0: Unit?) {
            db.itemDao().deleteAllItems()
        }
    }

    private class Update(var db: PersonDatabase):AsyncTask<Result,Unit,Unit>(){
        override fun doInBackground(vararg p0: Result?) {
            db.itemDao().updatePerson(p0[0]?.status!!,p0[0]?.phone!!)
        }

    }

    private class GetAllItems(var db:PersonDatabase):AsyncTask<Unit,Unit,List<Result>>(){
        override fun doInBackground(vararg p0: Unit?): List<Result> {
            return db.itemDao().getPersonList()
        }
    }
}