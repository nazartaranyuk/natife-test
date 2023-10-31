package com.nazartaraniuk.natifetest.domain

import com.nazartaraniuk.natifetest.data.model.GifsResponse

interface GifsLocalDataSource {

    suspend fun getCachedGiphs() : Result<GifsResponse>

    suspend fun cacheLoadedGiphs(gifs: GifsResponse)
}