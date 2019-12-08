package com.setoh.slotsample

import retrofit2.Call
import retrofit2.Response as RetrofitResponse
import okhttp3.Response as OkHttpResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface SampleApi {

    @FormUrlEncoded
    @POST("hogehoge")
    fun fetchData(
        @Header("header-name") headerName: String = "header-value",
        @Field("key1") key1: String = "value1"
    ): Call<String>
}