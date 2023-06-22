package com.bookfair.service

import com.bookfair.enums.BookStatus
import com.bookfair.enums.Errors
import com.bookfair.exception.NotFoundException
import com.bookfair.model.BookModel
import com.bookfair.model.CustomerModel
import com.bookfair.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun findAllActive(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ACTIVE, pageable)
    }

    fun findBookById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow{ NotFoundException(Errors.BF101.message.format(id), Errors.BF101.code) }
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
