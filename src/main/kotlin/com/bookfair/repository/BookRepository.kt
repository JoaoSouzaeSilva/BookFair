package com.bookfair.repository

import com.bookfair.enums.BookStatus
import com.bookfair.model.BookModel
import com.bookfair.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

//NOTE: CrudRepository does not know a findAll receiving pageable, but JpaRepository knows
interface BookRepository: JpaRepository<BookModel, Int> {
    abstract fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    abstract fun findByCustomer(customer: CustomerModel): List<BookModel>

    //fun findAll(pageable: Pageable): Page<BookModel>

}