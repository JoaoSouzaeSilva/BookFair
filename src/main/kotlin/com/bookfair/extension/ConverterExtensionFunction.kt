package com.bookfair.extension

import com.bookfair.controller.request.PostBookRequest
import com.bookfair.controller.request.PostCustomerRequest
import com.bookfair.controller.request.PutCustomerRequest
import com.bookfair.enums.BookStatus
import com.bookfair.model.BookModel
import com.bookfair.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email
    )
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(
        id = id,
        name = this.name,
        email = this.email
    )
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ACTIVE,
        customer = customer
    )
}