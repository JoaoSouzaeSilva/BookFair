package com.bookfair.service

import com.bookfair.controller.request.PostCustomerRequest
import com.bookfair.controller.request.PutCustomerRequest
import com.bookfair.model.CustomerModel
import com.bookfair.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    var customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name,true) }
        }
        return customers
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getCustomer(id: Int): CustomerModel {
        return customers.first { it.id == id }
    }

    fun updateCustomer(customer: CustomerModel) {
        customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun deleteCustomer(id: Int) {
        customers.removeIf { it.id == id }
    }

}