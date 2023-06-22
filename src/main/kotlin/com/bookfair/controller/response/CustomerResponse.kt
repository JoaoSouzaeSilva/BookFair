package com.bookfair.controller.response

import com.bookfair.enums.CustomerStatus

data class CustomerResponse (
    var id: Int? = null, //Default value

    var name: String,

    var email: String,

    var status: CustomerStatus
)
