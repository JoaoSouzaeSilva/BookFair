package com.bookfair.exception

class AuthenticationException(override val message: String, val errorCode: String) : Exception() {
}