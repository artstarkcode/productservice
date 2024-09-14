package com.arjun.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GetAllProductsResponseDto {
    private List<GetProductDto> products;
}
