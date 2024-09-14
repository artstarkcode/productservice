package com.arjun.productservice.dtos;

import com.arjun.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;

    public static CreateProductDto fromProduct(Product product){
        CreateProductDto responseDto = new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageURL(product.getImageUrl());
        return responseDto;
    }
}
