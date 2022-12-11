package com.nima.integrations.country

import com.nima.integrations.httpExecutor.CountryHttpClientBehavior

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Repository
import java.net.http.HttpResponse

@EnableScheduling
@Repository
class CountryApiRepository(val httpClient: CountryHttpClientBehavior) {

    fun getAllCountries():HttpResponse<String>{
        return httpClient.makeRequest("all")
    }

    fun getCountryByCapital(capital: String) : HttpResponse<String> {
        return httpClient.makeRequest("capital/${capital}")
    }
}