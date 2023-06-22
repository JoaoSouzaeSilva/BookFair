package com.bookfair.model

import com.bookfair.enums.BookStatus
import com.bookfair.enums.Errors
import com.bookfair.exception.BadRequestException
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if(field == BookStatus.CANCELED || field == BookStatus.DELETED)
                throw BadRequestException(Errors.BF102.message.format(field), Errors.BF102.code)
            field = value
        }

    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookStatus?): this(id, name, price, customer) {
            this.status = status
        }
}
