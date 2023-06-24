package com.bookfair.controller

import com.bookfair.controller.mapper.PurchaseMapper
import com.bookfair.controller.request.PostPurchaseRequest
import com.bookfair.controller.response.PurchaseResponse
import com.bookfair.extension.toResponse
import com.bookfair.service.CustomerService
import com.bookfair.service.PurchaseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("purchases")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: PostPurchaseRequest) {
        purchaseService.create(purchaseMapper.toModel(request))
    }

    @GetMapping
    fun getAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<PurchaseResponse> {
       return purchaseService.getAll(pageable).map { it.toResponse() }
    }

    @GetMapping("{customerId}")
    fun getAllFromCustomer(@PathVariable customerId: Int): List<PurchaseResponse> {
        return purchaseService.getAllFromCustomer(customerId).map { it.toResponse() }
    }
}