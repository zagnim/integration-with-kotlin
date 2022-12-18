package com.nima.integrations.aoc

import com.nima.integrations.httpExecutor.AOCHttpClientBehavior
import org.springframework.stereotype.Repository
import java.net.http.HttpResponse

@Repository
class AOCApiRepository(val httpClient: AOCHttpClientBehavior) {

    fun getQuizInputForYearAndDay(path: String, session: String): HttpResponse<String> {
        return httpClient.makeSecureRequest(path, session)
    }
}