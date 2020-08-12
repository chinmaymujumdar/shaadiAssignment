package com.example.shaadiassignment.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shaadiassignment.model_classes.Example
import com.example.shaadiassignment.model_classes.Result
import com.example.shaadiassignment.repository.DataRepository
import com.example.shaadiassignment.repository.OfflineRepository
import com.example.shaadiassignment.retrofit.APICallback
import com.example.shaadiassignment.retrofit.DefaultSubscriber
import com.example.shaadiassignment.retrofit.ServerCall

class PersonViewModel(application: Application) : AndroidViewModel(application) {

    private var repository:DataRepository?=null
    private var offlineRepository:OfflineRepository?=null
    public var personList=MutableLiveData<MutableList<Result>>()

    init {
        repository= DataRepository()
        offlineRepository= OfflineRepository(application)
    }

    fun getData(){
        if (checkInternet()) {
            Toast.makeText(getApplication(),"Fetching data...",Toast.LENGTH_SHORT).show()
            val serverCall = ServerCall<Example>()
            serverCall.execute(repository?.getData(), DefaultSubscriber<Example>(object : APICallback<Example> {
                override fun onSuccess(t: Example) {
                    personList.value?.clear()
                    personList.postValue(t.results as MutableList<Result>?)
                    offlineRepository?.deleteAll()
                    offlineRepository?.storeListToDB(t.results!!)
                }

                override fun onError(e: Throwable) {
                    Log.d("PersonViewModel",e.message)
                    Toast.makeText(getApplication(),"Error while fetching data",Toast.LENGTH_SHORT).show()
                    getDataFromDB()
                }

            }))
        }else{
            getDataFromDB()
        }
    }

    private fun getDataFromDB(){
        val list=offlineRepository?.getAllItem()
        personList.value?.clear()
        personList.postValue(list as MutableList<Result>?)
    }

    public fun update(position:Int,int: String){
        if (personList.value!=null){
            val item=personList.value?.get(position)
            item?.status=int
            offlineRepository?.update(item!!)
            personList.postValue(personList.value)
        }else{
            Toast.makeText(getApplication(),"Error occured while updating",Toast.LENGTH_SHORT).show()
        }

//        if (personList.value!=null) {
//            for (per in personList.value!!) {
//                if (per.phone.equals(mobile)){
//                    per.status=int
//                    offlineRepository?.update(per)
//                    personList.postValue(personList.value)
//                    break
//                }
//            }
//        }
    }

    private fun checkInternet(): Boolean {
        var status: Boolean=false
        val cm = getApplication<Application>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                status = true
                return status
            } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                status = true
                return status
            }
        } else {
            status = false
            return status
        }
        return status
    }
}