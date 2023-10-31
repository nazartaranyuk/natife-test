package com.nazartaraniuk.natifetest.presentation.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class NetworkCheck @Inject constructor(private val context: Context) {

    val isOnline
    get(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        @Suppress("DEPRECATION")
        return cm.activeNetworkInfo?.isAvailable ?: false && cm.activeNetworkInfo?.isConnected ?: false
    }

}