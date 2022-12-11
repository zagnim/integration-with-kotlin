package com.nima.integrations.httpExecutor

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class CountryHttpClientBehavior : HttpClientExecutor {
    private val client = HttpClient.newBuilder().build()
    private val baseUri = "https://restcountries.com/v3.1/"

    override fun makeRequest(path:String): HttpResponse<String> {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${baseUri}${path}"))
            .build()
        return client.send(request,HttpResponse.BodyHandlers.ofString())
    }
}