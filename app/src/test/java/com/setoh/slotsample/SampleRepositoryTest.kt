package com.setoh.slotsample

import com.google.common.truth.Truth.assertThat
import io.mockk.*
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.junit.Test

import org.junit.Before

class SampleRepositoryTest {

    @Test
    fun fetchData() {
        mockkObject(OkHttpClientProvider)

        val okHttpClient = mockk<OkHttpClient>() {
            every { newCall(any()) } returns mockk(relaxed = true)
        }
        every {
            OkHttpClientProvider.client
        } returns okHttpClient

        val sampleRepository = SampleRepository()

        sampleRepository.fetchData()

        val slot = slot<Request>()
        verify(exactly = 1) {
            okHttpClient.newCall(capture(slot))
        }
        val capturedRequest = slot.captured
        assertThat(capturedRequest.header("header-name")).isEqualTo("header-value")
        assertThat(capturedRequest.body).isInstanceOf(FormBody::class.java)
        val body = capturedRequest.body as FormBody
        assertThat(body.size).isEqualTo(1)
        assertThat(body.name(0)).isEqualTo("key1")
        assertThat(body.value(0)).isEqualTo("value1")

        unmockkObject(OkHttpClientProvider)
    }
}