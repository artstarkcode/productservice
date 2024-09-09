package com.arjun.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreCreateProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;
}
