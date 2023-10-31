package com.nazartaraniuk.natifetest.domain

import com.nazartaraniuk.natifetest.data.model.GifsResponse

interface GiphsRemoteDataSource {

    suspend fun loadGiphs() : GifsResponse
}