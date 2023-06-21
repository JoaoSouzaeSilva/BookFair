package com.bookfair.controller.request

import com.bookfair.model.CustomerModel

data class PostCustomerRequest(
    var name: String,
    var email: String
)