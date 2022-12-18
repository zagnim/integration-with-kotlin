package com.nima.integrations.aoc

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("si/aoc-quiz")
class AOCController(val apiRepository: AOCApiRepository) {

    //:2022/day/6/input:
    @GetMapping("input")
    fun getQuizInput(@RequestParam(name = "year", defaultValue = "2022", required = false) year:String,
                     @RequestParam(name = "day", defaultValue = "1", required = false) day:String,
                     @RequestHeader(name = "sessionId", required = true) sID:String)
    :ResponseEntity<String>{
        //return ResponseEntity(sID, HttpStatus.I_AM_A_TEAPOT)
        return ResponseEntity(
            this.apiRepository.getQuizInputForYearAndDay(
                "${year}/day/${day}/input",
                "session=${sID}").body(),
            HttpStatus.ACCEPTED
        )
    }
}