package com.setoh.slotsample

class SampleRemoteDataSource(
    private val api: SampleApi = ApiProvider().sampleApi
) {
    fun fetchData(): String? {
        return api.fetchData()
            .execute()
            .body()
    }
}