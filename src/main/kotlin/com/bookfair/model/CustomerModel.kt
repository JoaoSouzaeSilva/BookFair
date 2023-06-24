package com.bookfair.model

import com.bookfair.enums.CustomerStatus
import jakarta.persistence.*

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
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus,

    @Column
    var password: String
)