package com.nazartaraniuk.natifetest.presentation.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nazartaraniuk.natifetest.BuildConfig
import com.nazartaraniuk.natifetest.data.ApiKeyInterceptor
import com.nazartaraniuk.natifetest.data.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideGson() : Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setPrettyPrinting()
        return gsonBuilder
            .setLenient()
            .create()
    }

    @Provides
    fun provideOkhttpClient(interceptor: ApiKeyInterceptor) : OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(moshi: Gson) : GsonConverterFactory {
        return GsonConverterFactory.create(moshi)
    }

    @Provides
    fun provideRetrofit(gsonFactory: GsonConverterFactory, okHttpClient: OkHttpClient): ApiService {
        val retrofit =  Retrofit.Builder()
            .baseUrl(BuildConfig.API_KEY) // TODO add here BASE_URL
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
        return retrofit.create()
    }
}