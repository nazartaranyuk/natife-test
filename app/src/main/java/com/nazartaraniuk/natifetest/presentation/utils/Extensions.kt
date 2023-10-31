@file:JvmName("Utils")

package com.nazartaraniuk.natifetest.presentation.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


fun <T : RecyclerView.Adapter<*>> RecyclerView.attachLinearAdapter(adapter: T) {
    this.adapter = adapter
    this.layoutManager = LinearLayoutManager(this.context)
}