package com.bookfair.controller.request

import com.bookfair.model.CustomerModel
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest(

    @field:NotEmpty
    var name: String,

    @field:Email
    var email: String
)