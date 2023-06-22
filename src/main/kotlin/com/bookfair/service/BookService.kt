package com.bookfair.service

import com.bookfair.controller.request.PutBookRequest
import com.bookfair.enums.BookStatus
import com.bookfair.model.BookModel
import com.bookfair.model.CustomerModel
import com.bookfair.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun findAllActive(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ACTIVE)
    }

    fun findBookById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun deleteBook(id: Int) {
        val book = findBookById(id)

        book.status = BookStatus.CANCELED

        updateBook(book)
    }

    fun updateBook(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)

        for(book in books)
            book.status = BookStatus.DELETED

        bookRepository.saveAll(books)
    }



}
