package com.nima.integrations.moon

import com.nima.integrations.httpExecutor.MoonHttpClientBehavior
import org.springframework.stereotype.Repository
import java.net.http.HttpResponse

@Repository
class MoonApiRepository(val httpClient: MoonHttpClientBehavior) {

    fun getMoonPhaseForDate(path: String): HttpResponse<String>{
        return httpClient.makeRequest("?d=${path}")
    }
}