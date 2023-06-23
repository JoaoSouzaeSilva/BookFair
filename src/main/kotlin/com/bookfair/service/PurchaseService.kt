package com.bookfair.service

import com.bookfair.model.PurchaseModel
import com.bookfair.repository.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }

}
