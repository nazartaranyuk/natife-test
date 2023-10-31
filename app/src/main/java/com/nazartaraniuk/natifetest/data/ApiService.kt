package com.nazartaraniuk.natifetest.data

import com.nazartaraniuk.natifetest.data.model.GifsResponse
import retrofit2.http.GET


interface ApiService {

    @GET("v1/gifs/search")
    suspend fun loadGifs() : Result<GifsResponse>

}