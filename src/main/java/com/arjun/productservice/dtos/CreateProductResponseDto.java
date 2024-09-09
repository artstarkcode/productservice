package com.arjun.productservice.dtos;

import com.arjun.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;

    public static CreateProductResponseDto fromProduct(Product product){
        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageURL(product.getImageUrl());
        return responseDto;
    }
}
