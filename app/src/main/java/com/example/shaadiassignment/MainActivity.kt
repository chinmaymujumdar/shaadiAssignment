package com.example.shaadiassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shaadiassignment.adapter.PersonAdapter
import com.example.shaadiassignment.databinding.ActivityMainBinding
import com.example.shaadiassignment.model_classes.Result
import com.example.shaadiassignment.viewmodel.PersonViewModel

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding?=null
    private var viewModel:PersonViewModel?=null
    private var adapter: PersonAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel=ViewModelProviders.of(this).get(PersonViewModel::class.java)
        viewModel?.getData()

        viewModel?.personList?.observe(this, Observer<List<Result>> {
            handleRecycler(it)
        })
    }

    private fun handleRecycler(list: List<Result>){
        if (adapter==null){
            binding?.recycler?.layoutManager=LinearLayoutManager(this)
            adapter= PersonAdapter(viewModel)
            binding?.recycler?.adapter=adapter
            adapter?.submitList(list)
        }else{
            adapter?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }

    fun accept(item:Result,view:View){

    }

    fun reject(item: Result,view:View){

    }
}
