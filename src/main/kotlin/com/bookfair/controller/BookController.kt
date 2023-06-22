package com.bookfair.controller

import com.bookfair.controller.request.PostBookRequest
import com.bookfair.controller.request.PutBookRequest
import com.bookfair.extension.toBookModel
import com.bookfair.model.BookModel
import com.bookfair.service.BookService
import com.bookfair.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getCustomer(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    //Another way to represent the function.
    @GetMapping
    fun findAll(): List<BookModel> =
        bookService.findAll()

    @GetMapping("active")
    fun findAllActives(): List<BookModel> {
        return bookService.findAllActive()
    }

    @GetMapping("{id}")
    fun findBookById(@PathVariable id: Int): BookModel {
        return bookService.findBookById(id)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int) {
        bookService.deleteBook(id)
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBook(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findBookById(id)
        bookService.updateBook(book.toBookModel(bookSaved))
    }


}