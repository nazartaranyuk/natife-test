package com.nazartaraniuk.natifetest.presentation.di

import com.nazartaraniuk.natifetest.data.repository.GifsRepositoryImpl
import com.nazartaraniuk.natifetest.domain.GifsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindGifsRepository(implementation: GifsRepositoryImpl) : GifsRepository
}