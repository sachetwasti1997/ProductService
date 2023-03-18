package com.sachet.productservice.service

import com.sachet.productservice.model.Product

interface ProductService {

    fun save(product: Product): Product
    fun findById(id: Long): Product ?
    fun findAll(): List<Product>
    fun reduceQuantity(productId: Long, quantity: Long)
    fun delete(product: Product)
    fun deleteById(id: Long)

}