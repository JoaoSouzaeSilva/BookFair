package com.bookfair.controller.request

import com.bookfair.model.CustomerModel
import com.bookfair.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest(

    @field:NotEmpty(message = "Name field must be not empty")
    var name: String,

    @field:Email(message = "Email field must be a well formatted email address")
    @EmailAvailable
    var email: String
)