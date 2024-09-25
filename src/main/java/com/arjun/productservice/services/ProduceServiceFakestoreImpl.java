package com.arjun.productservice.services;

import com.arjun.productservice.dtos.fakestore.FakeStoreCreateProductRequestDto;
import com.arjun.productservice.dtos.fakestore.FakeStoreGetProductResponseDto;
import com.arjun.productservice.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
        request.setCategory(product.getCategory().getName());
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

    @Override
    public Product partialUpdateProduct(Long productId, Product product) {
//        FakeStoreGetProductResponseDto productResponseDto = restTemplate.exchange(
//                "https://fakestoreapi.com/products/" + productId,
//                HttpMethod.PATCH,
//                FakeStoreCreateProductRequestDto.fromProduct(product),
//                FakeStoreGetProductResponseDto.class
//        );

        HttpEntity<FakeStoreCreateProductRequestDto> requestEntity = new HttpEntity<>(FakeStoreCreateProductRequestDto.fromProduct(product));
        ResponseEntity<FakeStoreGetProductResponseDto> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + productId,
                HttpMethod.PATCH,
                requestEntity,
                FakeStoreGetProductResponseDto.class
        );


        return responseEntity.getBody().toProduct();
    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreGetProductResponseDto response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreGetProductResponseDto.class
        );
        return response.toProduct();
    }
}
