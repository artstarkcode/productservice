package com.arjun.productservice.repositories;

import com.arjun.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Update is also done using save() method
    // If the product we try to save already has an id, JPA will update the existing product
    // else it will insert a new product
    @Override
    Product save(Product product);

    @Override
    void deleteById(Long id);
    @Override
    boolean existsById(Long id);
    @Override
    List<Product> findAll();
    @Override
    Optional<Product> findById(Long id);

}
