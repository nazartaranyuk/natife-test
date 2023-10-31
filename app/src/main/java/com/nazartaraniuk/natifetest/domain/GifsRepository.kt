package com.nazartaraniuk.natifetest.domain

import com.nazartaraniuk.natifetest.data.model.GifsResponse
import kotlinx.coroutines.flow.Flow

interface GifsRepository {

    suspend fun loadGiphs() : Flow<Result<GifsResponse>>

    suspend fun loadCachedGiphs() : Flow<Result<GifsResponse>>
}