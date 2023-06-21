package com.bookfair.repository

import com.bookfair.enums.BookStatus
import com.bookfair.model.BookModel
import com.bookfair.model.CustomerModel
import org.springframework.data.repository.CrudRepository


interface BookRepository: CrudRepository<BookModel, Int> {
    abstract fun findByStatus(status: BookStatus): List<BookModel>
}