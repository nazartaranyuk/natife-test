package com.nazartaraniuk.natifetest.presentation.main_screen.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nazartaraniuk.natifetest.data.model.Data
import com.nazartaraniuk.natifetest.databinding.ActivityMainBinding

class GifsAdapter : ListAdapter<Data, GifsAdapter.ItemViewHolder>(
    DiffUtilCallback()
)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ItemViewHolder(private val binding: ActivityMainBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}