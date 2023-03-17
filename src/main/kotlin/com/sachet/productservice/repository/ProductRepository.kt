package com.sachet.productservice.repository

import com.sachet.productservice.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long>