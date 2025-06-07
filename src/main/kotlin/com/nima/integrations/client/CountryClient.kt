package com.nima.integrations.client

import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class CountryClient {
    private val client = HttpClient.newBuilder().build()
    private val baseURI = "https://restcountries.com/v3.1/"

    fun getCountry(path:String): HttpResponse<String> {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${baseURI}${path}"))
            .build()
        return client.send(request,HttpResponse.BodyHandlers.ofString())
    }
}