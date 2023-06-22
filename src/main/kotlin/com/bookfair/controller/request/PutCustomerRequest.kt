package com.bookfair.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PutCustomerRequest (

    @field:NotEmpty(message = "Name field must be not empty")
    var name: String,

    @field:Email(message = "Email field must be a well formatted email address")
    var email: String
)