package com.bookfair.enums

enum class Errors(val code: String, val message: String) {
    BF101("BF-101", "Book [%s] does not exist"),
    BF102("BF-102", "Cannot update book with status [%s]"),
    BF201("BF-201", "Customer with ID [%s] does not exist")

}