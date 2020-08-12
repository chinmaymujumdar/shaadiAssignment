package com.example.shaadiassignment.room_database

import androidx.room.*
import com.example.shaadiassignment.model_classes.Result

@Dao
interface ItemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllItems(photoList: List<Result>?)

    @Query("DELETE FROM Result")
    fun deleteAllItems()

    @Query("UPDATE Result SET status= :status WHERE phone = :phone")
    fun updatePerson(status:String,phone:String)

    @Query("Select * from Result")
    fun getPersonList(): List<Result>

}