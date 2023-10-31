package com.nazartaraniuk.natifetest.domain.use_case

import com.nazartaraniuk.natifetest.data.model.GifsResponse
import com.nazartaraniuk.natifetest.domain.GifsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoadGifsUseCase @Inject constructor(
    private val repository: GifsRepository
) {

    suspend operator fun invoke() : Flow<Result<GifsResponse>> {
        return repository.loadGiphs()

    }
}