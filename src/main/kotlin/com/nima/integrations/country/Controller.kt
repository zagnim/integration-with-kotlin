package com.nima.integrations.country

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpResponse

@RestController
@RequestMapping("si/countries")
class Controller(val countryCountryApiRepository: CountryApiRepository) {

    @GetMapping
    fun getAll(): ResponseEntity<String> {
        return ResponseEntity(
            countryCountryApiRepository.getAllCountries().body(),
            HttpStatus.ACCEPTED
        )
    }

    @GetMapping("capital/{capital}")
    fun getCountryByCapital(@PathVariable(name = "capital") capital:String)
    :ResponseEntity<String>{
        return ResponseEntity(
            countryCountryApiRepository.getCountryByCapital(capital).body(),
            HttpStatus.ACCEPTED
        )
    }

}