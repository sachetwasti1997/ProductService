package com.sachet.productservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var productId: Long ?= null,
    var productName: String ?= null,
    var price: Double ?= null,
    var quantity: Double ?= null
)