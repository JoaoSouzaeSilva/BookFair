package com.bookfair.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @GetMapping
    @RequestMapping("/")
    fun helloWorld(): String {
        return "Hello World"
    }

}