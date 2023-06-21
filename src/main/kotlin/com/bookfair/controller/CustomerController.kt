package com.bookfair.controller

import com.bookfair.controller.request.PostCustomerRequest
import com.bookfair.controller.request.PutCustomerRequest
import com.bookfair.model.CustomerModel
import com.bookfair.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController(
        val customerService: CustomerService
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        return customerService.createCustomer(customer)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: String, @RequestBody customer: PutCustomerRequest) {
        return customerService.updateCustomer(id, customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: String) {
        customerService.deleteCustomer(id)
    }
}