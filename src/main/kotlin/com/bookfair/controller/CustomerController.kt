package com.bookfair.controller

import com.bookfair.controller.request.PostCustomerRequest
import com.bookfair.model.CustomerModel
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("customers")
class CustomerController {

    var customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getAll(): List<CustomerModel> {
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        val newId = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(CustomerModel(newId, customer.name, customer.email))
        println(customer)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }
}