package com.example.frango

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FrangoApplication

fun main(args: Array<String>) {
	runApplication<FrangoApplication>(*args)
}
