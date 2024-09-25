package com.arjun.productservice.dtos.fakestore;

import com.arjun.productservice.models.Category;
import com.arjun.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreGetProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String image;
    private String description;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setDescription(this.description);
        product.setTitle(this.title);
        product.setPrice(this.price);
        product.setImageUrl(this.image);
        Category category1 = new Category();
        category1.setName(this.category);
        product.setCategory(category1);
        return product;
    }
}
