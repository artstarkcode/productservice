package com.arjun.productservice.dtos.products;

import com.arjun.productservice.models.Category;
import com.arjun.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public Product toProduct(){
        Product product = new Product();
        product.setTitle(this.getTitle());
        product.setPrice(this.getPrice());
        Category category = new Category();
        category.setName(this.getCategoryName());
        product.setCategory(category);
        product.setDescription(this.getDescription());
        product.setImageUrl(this.getImageUrl());
        return product;
    }
}
