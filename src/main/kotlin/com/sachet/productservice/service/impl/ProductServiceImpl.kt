package com.sachet.productservice.service.impl

import com.sachet.productservice.exception.NotFoundException
import com.sachet.productservice.model.Product
import com.sachet.productservice.repository.ProductRepository
import com.sachet.productservice.service.ProductService
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {
    override fun save(product: Product): Product {
        return productRepository.save(product)
    }

    override fun findById(id: Long): Product? {
        val product = productRepository.findById(id)
        if (!product.isPresent) throw NotFoundException("Product with Id $id not found.")
        return product.get()
    }

    override fun findAll(): List<Product> {
        return productRepository.findAll()
    }

    override fun reduceQuantity(productId: Long, quantity: Long) {
        val product = productRepository
            .findById(productId)
            .orElseThrow{
                NotFoundException("Product with id $productId Not Found")
            }
        if (product.quantity!! < quantity) {
            throw Exception("Product does not have sufficient Quantity")
        }
        product.quantity = product.quantity!! - quantity
        productRepository.save(product)
    }

    override fun delete(product: Product) {
        productRepository.delete(product)
    }

    override fun deleteById(id: Long) {
        productRepository.deleteById(id)
    }
}