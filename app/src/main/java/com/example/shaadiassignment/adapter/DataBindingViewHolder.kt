package com.example.carwaleassignment.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.shaadiassignment.BR
import com.example.shaadiassignment.viewmodel.PersonViewModel

class DataBindingViewHolder<T>(val binding:ViewDataBinding,val viewModel: PersonViewModel?): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: T){
        binding.setVariable(BR.data,item)
        binding.setVariable(BR.position,adapterPosition)
        binding.setVariable(BR.viewModel,viewModel)
        binding.executePendingBindings()
    }
}