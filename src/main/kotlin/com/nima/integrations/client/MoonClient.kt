package com.nima.integrations.client

import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class MoonClient{
    private val client = HttpClient.newBuilder().build()
    private val baseURI = "https://api.farmsense.net/v1/moonphases"

    fun getMoonPhases(path: String): HttpResponse<String> {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${baseURI}/${path}"))
            .build()

        return client.send(request,HttpResponse.BodyHandlers.ofString())
    }
}