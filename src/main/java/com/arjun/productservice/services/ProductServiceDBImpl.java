package com.arjun.productservice.services;

import com.arjun.productservice.exceptions.ProductNotFoundException;
import com.arjun.productservice.models.Category;
import com.arjun.productservice.models.Product;
import com.arjun.productservice.repositories.CategoryRepository;
import com.arjun.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public ProductServiceDBImpl(ProductRepository productRepository,
                                CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product createProduct(Product product) {
        Category categoryToBePutInProduct = getCategoryToBePutInProduct(product);
        product.setCategory(categoryToBePutInProduct);
          Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product partialUpdateProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> productToUpdateOptional = productRepository.findById(productId);
        if (productToUpdateOptional.isEmpty()){
            throw new ProductNotFoundException(productId);
        }
        Product productToUpdate = productToUpdateOptional.get();
        if (product.getDescription() != null){
            productToUpdate.setDescription(product.getDescription());
        }
        if (product.getPrice() != null){
            productToUpdate.setPrice(product.getPrice());
        }
        if (product.getTitle() != null){
            productToUpdate.setTitle(product.getTitle());
        }
        if (product.getCategory() != null){
            Category categoryToBePutInProduct = getCategoryToBePutInProduct(product);
            productToUpdate.setCategory(categoryToBePutInProduct);
        }
        if (product.getImageUrl() != null){
            productToUpdate.setImageUrl(product.getImageUrl());
        }
        return productRepository.save(productToUpdate);
    }

    private Category getCategoryToBePutInProduct(Product product) {
        String categoryName = product.getCategory().getName();

        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);
        Category categoryToBePutInProduct = null;
        if (categoryOptional.isEmpty()){
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);
            categoryToBePutInProduct = categoryRepository.save(toSaveCategory);
        } else {
            categoryToBePutInProduct = categoryOptional.get();
        }
        return categoryToBePutInProduct;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {

        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()){
            throw new ProductNotFoundException(id);
        }
        return productOptional.get();
    }
    public void deleteProduct(Long id) throws ProductNotFoundException {
        boolean ifProductExists = productRepository.existsById(id);
        if (!ifProductExists){
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()){
            throw new ProductNotFoundException(id);
        }
        Product productToReplace = productOptional.get();
        productToReplace.setCategory(product.getCategory());
        productToReplace.setDescription(product.getDescription());
        productToReplace.setImageUrl(product.getImageUrl());
        productToReplace.setPrice(product.getPrice());
        productToReplace.setTitle(product.getTitle());
        return productRepository.save(productToReplace);
    }
}
