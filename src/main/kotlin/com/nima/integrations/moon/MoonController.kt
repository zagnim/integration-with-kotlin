package com.nima.integrations.moon

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.client.RestTemplate
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
@RequestMapping("si/moon")
class MoonController {
    val restTemplate = RestTemplate()

    @GetMapping
    fun getMoonDataForGivenDate(
        @RequestParam(name = "date") date: String): ResponseEntity<Any> {
        return restTemplate.getForEntity("https://api.farmsense.net/v1/moonphases/?d=" +
                "${Timestamp
                    .valueOf(
                        if(date.isEmpty()||date.isBlank()) LocalDateTime.now()
                        else LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE)//YYYY-MM-DD
                ).nanos}",
                Any::class.java
        )
    }
}
