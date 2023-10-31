package com.nazartaraniuk.natifetest.data.repository

import com.nazartaraniuk.natifetest.data.handleCatching
import com.nazartaraniuk.natifetest.data.model.GifsResponse
import com.nazartaraniuk.natifetest.domain.GifsLocalDataSource
import com.nazartaraniuk.natifetest.domain.GifsRepository
import com.nazartaraniuk.natifetest.domain.GiphsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GifsRepositoryImpl @Inject constructor(
    private val localDataSource: GifsLocalDataSource,
    private val remoteDataSource: GiphsRemoteDataSource,
) : GifsRepository {

    override suspend fun loadGiphs() : Flow<Result<GifsResponse>> {
        return flow {
            val result = handleCatching {
                val gifs = remoteDataSource.loadGiphs()
                localDataSource.cacheLoadedGiphs(gifs)
                gifs
            }
            emit(result)
        }

    }

    override suspend fun loadCachedGiphs(): Flow<Result<GifsResponse>> {
        return flow {
            val result = localDataSource.getCachedGiphs()
            emit(result)
        }
    }
}