package com.arjun.productservice.services;

import com.arjun.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.arjun.productservice.dtos.FakeStoreCreateProductResponseDto;
import com.arjun.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class ProduceServiceFakestoreImpl implements ProductService{
    private RestTemplate restTemplate;
    public ProduceServiceFakestoreImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto request = new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategoryName());
        request.setTitle(product.getTitle());
        request.setDescription(product.getDescription());
        request.setImage(product.getImageUrl());
        request.setPrice(product.getPrice());
        FakeStoreCreateProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreCreateProductResponseDto.class
        );
        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setImageUrl(response.getImage());
        product1.setDescription(response.getDescription());
        product1.setCategoryName(response.getCategory());
        product1.setPrice(response.getPrice());
        product1.setTitle(response.getTitle());
        return product1;
    }

    @Override
    public List<Product> getAllProducts() {
        /*
        List<FakeStoreCreateProductResponseDto> responseList = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                List<FakeStoreCreateProductResponseDto.class>);

         */
        return List.of();
    }
}
