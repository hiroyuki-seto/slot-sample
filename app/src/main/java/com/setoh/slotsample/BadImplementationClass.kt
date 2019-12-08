package com.setoh.slotsample

import okhttp3.*

class BadImplementationClass {
    companion object {
        fun fetchData(): String? {
            val body = FormBody.Builder()
                .add("key1", "value1")
                .build()
            val request = Request.Builder()
                .url("https://hoge.com/api/fugafuga")
                .header("header-name", "header-value")
                .post(body)
                .build()

            return OkHttpClientProvider.client
                .newCall(request)
                .execute()
                .body?.string()
        }
    }
}