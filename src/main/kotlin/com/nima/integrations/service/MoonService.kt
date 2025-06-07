package com.nima.integrations.service

import com.nima.integrations.client.MoonClient
import org.springframework.stereotype.Repository
import java.net.http.HttpResponse
import java.text.DateFormat
import java.text.SimpleDateFormat

@Repository
class MoonService(val httpClient: MoonClient) {

    fun getMoonPhaseForDate(date: String): String{
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd");
        val d: Long = dateFormat.parse(date).time
        return httpClient.getMoonPhases("?d=${d}").body()
    }
}