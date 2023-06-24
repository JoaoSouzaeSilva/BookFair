package com.bookfair.service

import com.bookfair.events.PurchaseEvent
import com.bookfair.model.PurchaseModel
import com.bookfair.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
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

}
