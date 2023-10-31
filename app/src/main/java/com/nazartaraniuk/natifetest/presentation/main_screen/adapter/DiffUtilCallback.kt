package com.nazartaraniuk.natifetest.presentation.main_screen.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.nazartaraniuk.natifetest.data.model.Data

class DiffUtilCallback : DiffUtil.ItemCallback<Data>() {

    override fun areItemsTheSame(
        oldItem: Data,
        newItem: Data
    ): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: Data,
        newItem: Data
    ): Boolean {
        return oldItem.id == newItem.id
    }
}