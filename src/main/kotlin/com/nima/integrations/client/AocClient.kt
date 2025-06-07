package com.nima.integrations.client

import org.springframework.stereotype.Service
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class AocClient{
    private val client = HttpClient.newBuilder().build()
    private val baseURI:String = "https://adventofcode.com"

     fun getQuizData(year: Int, day: Int): HttpResponse<String> {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("${baseURI}/${year}/day/${day}/input"))
            .header("cookie", getToken())
            .build()
        return client.send(request,HttpResponse.BodyHandlers.ofString())
     }

    fun getToken(): String {
        return "something"
    }
}