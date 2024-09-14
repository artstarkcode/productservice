package com.arjun.productservice.controllers;

import com.arjun.productservice.dtos.CreateProductRequestDto;
import com.arjun.productservice.dtos.CreateProductResponseDto;
import com.arjun.productservice.dtos.GetAllProductsResponseDto;
import com.arjun.productservice.dtos.GetProductDto;
import com.arjun.productservice.models.Product;
import com.arjun.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }
    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product = productService.createProduct(
                createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
        // return "The Produce is priced at: Rs." + createProductRequestDto.getPrice();
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProducts(){
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto response = new GetAllProductsResponseDto();
        List<GetProductDto> getProductResponseDtos = new ArrayList<>();
        for (Product product : products){
            getProductResponseDtos.add(GetProductDto.fromProduct(product));
        }
        response.setProducts(getProductResponseDtos);
        return response;
    }
    @GetMapping("/{id}")
    public void getProductById(@PathVariable("id") Long id){

    }

    public void uppdateProduct(){

    }
    public void replaceProduct(){

    }
    /*
    @RequestMapping(name = "ARJUN", value = "")
    public String somethingFromArjun(){
        return "Magic from Arjun";
    }
     */
}
