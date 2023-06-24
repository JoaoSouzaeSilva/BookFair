package com.bookfair.controller.response

import com.bookfair.model.BookModel
import com.bookfair.model.CustomerModel
import java.math.BigDecimal
import java.time.LocalDateTime

data class PurchaseResponse (

    var id: Int? = null,

    var customer: CustomerModel,

    var books: MutableList<BookModel>,

    var nfe: String? = null,

    var price: BigDecimal,

    var createdAt: LocalDateTime
)
