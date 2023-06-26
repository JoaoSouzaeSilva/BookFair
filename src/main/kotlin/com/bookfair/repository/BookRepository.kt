package com.bookfair.repository

import com.bookfair.enums.BookStatus
import com.bookfair.model.BookModel
import com.bookfair.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookModel, Int> {

    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>

//    fun findAll(pageable: Pageable): Page<BookModel>

}