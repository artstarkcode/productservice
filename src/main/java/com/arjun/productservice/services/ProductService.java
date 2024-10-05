package com.arjun.productservice.services;

import com.arjun.productservice.exceptions.ProductNotFoundException;
import com.arjun.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product partialUpdateProduct(Long productId, Product product) throws ProductNotFoundException;
    Product getProductById(Long id) throws ProductNotFoundException;
    void deleteProduct(Long id) throws ProductNotFoundException;
    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;
}
