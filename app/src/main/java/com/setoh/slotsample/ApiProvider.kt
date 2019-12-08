package com.setoh.slotsample

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiProvider(
    client: OkHttpClient = OkHttpClientProvider.client
) {
    val sampleApi: SampleApi

    init {
        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://hoge.com/api/")
            .build()
        sampleApi = retrofit.create(SampleApi::class.java)
    }
}