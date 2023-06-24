package com.bookfair.service

import com.bookfair.events.PurchaseEvent
import com.bookfair.model.PurchaseModel
import com.bookfair.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)

        //publish the event
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }

    fun getAll(pageable: Pageable): Page<PurchaseModel> {
        return purchaseRepository.findAll(pageable)
    }

    fun getAllFromCustomer(customerId: Int): List<PurchaseModel> {
        return purchaseRepository.findAllByCustomerId(customerId)
    }

}
