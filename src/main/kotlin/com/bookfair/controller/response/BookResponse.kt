package com.bookfair.controller.response

import com.bookfair.enums.BookStatus
import com.bookfair.model.CustomerModel
import java.math.BigDecimal

data class BookResponse (

    var id: Int? = null, //Default value

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: BookStatus? = null
)
