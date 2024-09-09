package com.arjun.productservice.services;

import com.arjun.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
}
