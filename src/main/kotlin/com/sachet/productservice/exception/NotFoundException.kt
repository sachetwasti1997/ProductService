package com.sachet.productservice.exception

class NotFoundException(private val errorMessage: String): RuntimeException(errorMessage)