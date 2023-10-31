package com.nazartaraniuk.natifetest.data.model

import com.google.gson.annotations.SerializedName

data class Analytics(
    @SerializedName("onclick") val onClick: Onclick,
    @SerializedName("onload") val onLoad: Onload,
    @SerializedName("onsent") val onSent: Onsent
)