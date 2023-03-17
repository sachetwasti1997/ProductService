package com.sachet.productservice.model

import org.springframework.http.HttpStatus

class ErrorMessage (
    val message: String ?= null,
    val status: HttpStatus ?= null
)