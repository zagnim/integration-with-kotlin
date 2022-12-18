package com.nima.integrations.moon

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.sql.Timestamp
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors

@RestController
@RequestMapping("si/moon")
class MoonController(val apiRepository: MoonApiRepository) {

    @GetMapping
    fun getMoonDataForGivenDate(
        @RequestParam(name = "date", required = false, defaultValue = "2018-08-25") date: String
    ):ResponseEntity<String> {
        val dateFormat:DateFormat = SimpleDateFormat("yyyy-MM-dd");
        val d: Long = dateFormat.parse(date).time
        return ResponseEntity(apiRepository.getMoonPhaseForDate("$d").body(), HttpStatus.OK)
    }
}
