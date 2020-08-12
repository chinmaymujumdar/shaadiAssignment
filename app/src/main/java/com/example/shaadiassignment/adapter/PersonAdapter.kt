package com.example.shaadiassignment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.carwaleassignment.adapter.DataBindingAdapter
import com.example.carwaleassignment.adapter.DataBindingViewHolder
import com.example.shaadiassignment.R
import com.example.shaadiassignment.model_classes.Result
import com.example.shaadiassignment.viewmodel.PersonViewModel

class PersonAdapter(viewModel: PersonViewModel?): DataBindingAdapter<Result>(DiffCallBack(),viewModel) {

    class DiffCallBack: DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return false
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.person_item
    }
}