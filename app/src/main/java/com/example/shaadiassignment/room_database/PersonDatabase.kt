package com.example.shaadiassignment.room_database

import android.content.Context
import androidx.room.*
import com.example.shaadiassignment.model_classes.Result

@Database(entities = arrayOf(Result::class),version = 1)
@TypeConverters(Converter::class)
abstract class PersonDatabase: RoomDatabase() {

    abstract fun itemDao():ItemDAO

    companion object{
        private var instance:PersonDatabase?=null

        fun getInstance(context:Context):PersonDatabase?{
            if (instance==null){
                synchronized(PersonDatabase::class) {
                    instance =
                        Room.databaseBuilder(context,PersonDatabase::class.java,"person_db").build()
                }
            }
            return instance
        }
    }
}