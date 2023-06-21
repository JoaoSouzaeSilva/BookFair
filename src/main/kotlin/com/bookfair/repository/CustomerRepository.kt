package com.bookfair.repository

import com.bookfair.model.CustomerModel
import org.springframework.data.repository.CrudRepository


interface CustomerRepository: CrudRepository<CustomerModel, Int> {

}