package com.bookfair.controller

import com.bookfair.controller.request.PostBookRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookController(

) {

    @PostMapping
    fun create(@RequestBody request: PostBookRequest) {

    }

}