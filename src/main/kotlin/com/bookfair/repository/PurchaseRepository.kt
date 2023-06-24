package com.bookfair.repository

import com.bookfair.model.PurchaseModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PurchaseRepository: JpaRepository<PurchaseModel, Int> {
    abstract fun findAllByCustomerId(customerId: Int): List<PurchaseModel>

}
