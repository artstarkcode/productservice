package com.arjun.productservice.services;

import com.arjun.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.arjun.productservice.dtos.FakeStoreGetProductResponseDto;
import com.arjun.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
        FakeStoreGetProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreGetProductResponseDto.class
        );
        return response.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreGetProductResponseDto[] response = restTemplate.getForObject(
             "https://fakestoreapi.com/products",
                FakeStoreGetProductResponseDto[].class
        );
        List<FakeStoreGetProductResponseDto> responseDtoList =
                Stream.of(response).toList();
        List<Product> products = new ArrayList<>();
        for (FakeStoreGetProductResponseDto responseDto : responseDtoList){
            products.add(responseDto.toProduct());
        }
        return products;
    }
}
