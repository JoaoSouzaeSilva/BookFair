package com.bookfair.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class PostBookRequest(

    @field:NotEmpty(message = "Name field must not be empty")
    var name: String,

    @field:NotNull(message = "Book must have a price")
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int
)