package com.bookfair

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class BookFairApplication

fun main(args: Array<String>) {
	runApplication<BookFairApplication>(*args)
}
