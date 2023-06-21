package com.bookfair.controller

import com.bookfair.controller.request.PostBookRequest
import com.bookfair.extension.toBookModel
import com.bookfair.service.BookService
import com.bookfair.service.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getCustomer(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

}