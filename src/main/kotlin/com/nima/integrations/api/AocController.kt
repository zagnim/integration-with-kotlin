package com.nima.integrations.api

import com.nima.integrations.exception.CustomException
import com.nima.integrations.service.AocService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("si/aoc")
class AocController(val aocService: AocService) {

    //:2022/day/6/input:
    @GetMapping("input")
    fun getQuizInput(@RequestParam(name = "year", defaultValue = "2022", required = false) year:Int,
                     @RequestParam(name = "day", defaultValue = "1", required = false) day:Int,
                     //@RequestHeader(name = "sessionId", required = true) sID:String
    ):ResponseEntity<String>{
        return try {
            ResponseEntity(
                aocService.getQuizInputForYearAndDay(year, day),
                HttpStatus.ACCEPTED
            )
        } catch (e: CustomException) {
            ResponseEntity(
                e.message,
                HttpStatus.BAD_REQUEST
            )
        }

    }
}