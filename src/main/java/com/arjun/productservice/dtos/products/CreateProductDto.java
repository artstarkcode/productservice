package com.arjun.productservice.dtos.products;

import com.arjun.productservice.models.Category;
import com.arjun.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageURL;
    private String categoryName;

    public static CreateProductDto fromProduct(Product product){
        CreateProductDto responseDto = new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageURL(product.getImageUrl());
        return responseDto;
    }
    public Product toProduct(){
        Product product = new Product();
        product.setTitle(this.getTitle());
        product.setPrice(this.getPrice());
        Category category = new Category();
        category.setName(categoryName);
        product.setCategory(category);
        product.setDescription(this.getDescription());
        product.setImageUrl(this.getImageURL());
        return product;
    }
}
