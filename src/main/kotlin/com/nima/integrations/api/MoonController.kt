package com.nima.integrations.api

import com.nima.integrations.service.MoonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.DateFormat
import java.text.SimpleDateFormat

@RestController
@RequestMapping("si/moon")
class MoonController(val moonService: MoonService) {

    @GetMapping
    fun getMoonDataForGivenDate(
        @RequestParam(name = "date", required = false, defaultValue = "2018-08-25") date: String
    ):ResponseEntity<String> {
        return ResponseEntity(moonService.getMoonPhaseForDate(date), HttpStatus.OK)
    }
}
