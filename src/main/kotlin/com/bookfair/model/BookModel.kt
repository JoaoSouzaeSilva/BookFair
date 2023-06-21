package com.bookfair.model

import com.bookfair.enums.BookStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name="book")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null, //Default value

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
)