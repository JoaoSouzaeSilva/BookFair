package com.bookfair.service

import com.bookfair.enums.CustomerStatus
import com.bookfair.enums.Errors
import com.bookfair.exception.NotFoundException
import com.bookfair.model.CustomerModel
import com.bookfair.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(name)
        }
        return customerRepository.findAll().toList()
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow{ NotFoundException(Errors.BF201.message.format(id), Errors.BF201.code) }
    }

    fun updateCustomer(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }

        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int) {
        val customer = getCustomer(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INACTIVE

        customerRepository.save(customer)
    }

    fun emailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }

}