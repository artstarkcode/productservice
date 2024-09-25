package com.arjun.productservice.dtos.products;

import com.arjun.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public static GetProductDto fromProduct(Product product){
        GetProductDto responseDto = new GetProductDto();
        responseDto.setId(product.getId());
        responseDto.setDescription(product.getDescription());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setCategoryName(product.getCategory().getName());
        return responseDto;
    }
}
