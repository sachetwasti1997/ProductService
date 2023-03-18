package com.sachet.productservice.exception

import org.springframework.http.HttpStatus

class NotFoundException(private val errorMessage: String): RuntimeException(errorMessage)

class ErrorResponse(
    val errorMessage: String,
    val errorCode: HttpStatus
)