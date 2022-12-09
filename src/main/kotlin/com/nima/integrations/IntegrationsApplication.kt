package com.nima.integrations

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IntegrationsApplication

fun main(args: Array<String>) {
	runApplication<IntegrationsApplication>(*args)
}
