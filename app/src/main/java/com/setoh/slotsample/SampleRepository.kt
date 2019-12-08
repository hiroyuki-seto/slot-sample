package com.setoh.slotsample

class SampleRepository(
    private val remoteDataSource: SampleRemoteDataSource = SampleRemoteDataSource()
) {

    fun fetchData(): String? {
        return remoteDataSource.fetchData()
    }
}