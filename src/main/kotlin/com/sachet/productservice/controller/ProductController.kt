package com.sachet.productservice.controller

import com.sachet.productservice.model.Product
import com.sachet.productservice.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/product")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping("/create")
    fun createProduct(@RequestBody product: Product)
    = ResponseEntity(productService.save(product), HttpStatus.OK)

    @GetMapping("/all")
    fun getAllProduct() = ResponseEntity(productService.findAll(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = ResponseEntity(productService.findById(id), HttpStatus.OK)

    @DeleteMapping("/delete")
    fun delete(@RequestBody product: Product): ResponseEntity<String> {
        productService.delete(product)
        return ResponseEntity("The product with Id ${product.productId} deleted!", HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable id: Long) : ResponseEntity<String> {
        productService.deleteById(id)
        return ResponseEntity("The product Id $id deleted!", HttpStatus.OK)
    }
}