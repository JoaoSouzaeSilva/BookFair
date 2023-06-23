package com.bookfair.repository

import com.bookfair.model.PurchaseModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PurchaseRepository: CrudRepository<PurchaseModel, Int> {

}
