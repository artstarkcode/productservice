package com.arjun.productservice.dtos.fakestore;

import com.arjun.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductRequestDto {
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public static FakeStoreCreateProductRequestDto fromProduct(Product product){
        FakeStoreCreateProductRequestDto requestDto = new FakeStoreCreateProductRequestDto();
        requestDto.setDescription(product.getDescription());
        requestDto.setTitle(product.getTitle());
        requestDto.setPrice(product.getPrice());
        requestDto.setImage(product.getImageUrl());
        requestDto.setCategory(product.getCategory().getName());
        return requestDto;
    }
}
