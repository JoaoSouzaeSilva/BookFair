package com.bookfair.model

import com.bookfair.enums.CustomerStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name="customer")
data class CustomerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null, //Default value

    @Column
    var name: String,

    @Column
    var email: String,

    @Column
    var status: CustomerStatus
)