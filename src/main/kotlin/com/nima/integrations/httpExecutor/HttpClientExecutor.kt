package com.nima.integrations.httpExecutor

import org.springframework.stereotype.Service
import java.net.http.HttpResponse

@Service
interface HttpClientExecutor {
    fun makeRequest(path: String): HttpResponse<String>
}