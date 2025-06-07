package com.nima.integrations.service

import com.nima.integrations.client.AocClient
import com.nima.integrations.exception.CustomException
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class AocService(val httpClient: AocClient) {

    fun getQuizInputForYearAndDay(year: Int, day: Int): String{
        if(year>LocalDate.now().year || year<2015) {
            throw CustomException("ClientError: wrong year")
        }
        if(day<1 || day >31) {
            throw CustomException("ClientError: wrong day")
        }

        return httpClient.getQuizData(year, day).body()
    }
}