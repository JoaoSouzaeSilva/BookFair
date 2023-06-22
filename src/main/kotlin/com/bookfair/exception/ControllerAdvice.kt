package com.bookfair.exception

import com.bookfair.controller.response.ErrorResponse
import com.bookfair.controller.response.FieldErrorResponse
import com.bookfair.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error =  ErrorResponse (
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error =  ErrorResponse (
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error =  ErrorResponse (
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            ex.message,
            Errors.BF001.code,
            ex.bindingResult.fieldErrors.map { FieldErrorResponse (it.defaultMessage ?: "Invalid", it.field) }
        )

        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}