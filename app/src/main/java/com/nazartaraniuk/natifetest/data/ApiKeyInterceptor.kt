package com.nazartaraniuk.natifetest.data

import com.nazartaraniuk.natifetest.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {


    private fun apiKeyAsQuery(chain: Interceptor.Chain) : Request {
        return chain.request()
            .newBuilder()
            .url(
                chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .build()
            )
            .build()
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(apiKeyAsQuery(chain))
    }
}