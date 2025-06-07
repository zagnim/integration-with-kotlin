package com.nima.integrations.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.nima.integrations.service.CountryService


@RestController
@RequestMapping("si/countries")
class CountryController(val countryService: CountryService) {

    @GetMapping
    fun getAll(): ResponseEntity<String> {
        return ResponseEntity(
            countryService.getAllCountries(),
            HttpStatus.ACCEPTED
        )
    }

    @GetMapping("capital/{capital}")
    fun getCountryByCapital(@PathVariable(name = "capital") capital:String)
    :ResponseEntity<String>{
        return ResponseEntity(
            countryService.getCountryByCapital(capital),
            HttpStatus.ACCEPTED
        )
    }
}