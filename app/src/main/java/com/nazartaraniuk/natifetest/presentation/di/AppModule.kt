package com.nazartaraniuk.natifetest.presentation.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    NetworkModule::class
])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

}