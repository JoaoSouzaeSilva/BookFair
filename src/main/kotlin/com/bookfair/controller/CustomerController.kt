package com.bookfair.controller

import com.bookfair.controller.request.PostCustomerRequest
import com.bookfair.model.CustomerModel
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customers")
class CustomerController {

    @GetMapping
    fun getCustomer(): CustomerModel {
        return CustomerModel("1","João","joao@gmail.com")
    }

    @PostMapping
    fun createCustomer(@RequestBody customer: PostCustomerRequest): PostCustomerRequest {
        return customer
    }
}