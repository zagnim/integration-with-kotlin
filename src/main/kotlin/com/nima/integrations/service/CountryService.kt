package com.nima.integrations.service

import com.nima.integrations.client.CountryClient

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Repository
import java.net.http.HttpResponse

@EnableScheduling
@Repository
class CountryService(val httpClient: CountryClient) {

    fun getAllCountries(): String{
        return httpClient.getCountry("all").body()
    }

    fun getCountryByCapital(capital: String): String {
        return httpClient.getCountry("capital/${capital}").body()
    }
}