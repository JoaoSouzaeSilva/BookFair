package com.bookfair.repository

import com.bookfair.model.BookModel
import com.bookfair.model.CustomerModel
import org.springframework.data.repository.CrudRepository


interface BookRepository: CrudRepository<BookModel, Int> {

}