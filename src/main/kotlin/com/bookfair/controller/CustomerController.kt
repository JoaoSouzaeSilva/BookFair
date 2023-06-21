package com.bookfair.controller

import com.bookfair.controller.request.PostCustomerRequest
import com.bookfair.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController {

    val customers = ;

    @GetMapping
    fun getCustomer(): CustomerModel {
        return CustomerModel("1","João","joao@gmail.com")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest): PostCustomerRequest {
        return customer
    }
}