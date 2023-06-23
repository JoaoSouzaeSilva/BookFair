package com.bookfair.controller.mapper

import com.bookfair.controller.request.PostPurchaseRequest
import com.bookfair.model.PurchaseModel
import com.bookfair.service.BookService
import com.bookfair.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.getCustomer(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books,
            price = books.sumOf { it.price }
        )
    }
}