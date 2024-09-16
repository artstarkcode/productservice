package com.arjun.productservice.dtos.products;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProductResponseDto {
    private GetProductDto product;
}
