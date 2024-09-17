package com.arjun.productservice.controllers;

import com.arjun.productservice.dtos.ErrorResponseDto;
import com.arjun.productservice.dtos.products.*;
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
    public GetProductDto getProductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        GetProductDto getProductDto = GetProductDto.fromProduct(product);
        return getProductDto;
    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(@PathVariable("id") Long productId,
                                                 @RequestBody CreateProductDto productDto){
        Product product = productService.partialUpdateProduct(productId, productDto.toProduct());
        PatchProductResponseDto response = new PatchProductResponseDto();
        response.setProduct(GetProductDto.fromProduct(product));
        return response;
    }
    public void replaceProduct(){

    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRunTimeException(){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage("Something went wrong");
        errorResponseDto.setStatus("RUNTIME ERROR");
        return errorResponseDto;
    }
    @ExceptionHandler(Exception.class)
    public String handlException(){
        return "something went wrong";
    }
    /*
    @RequestMapping(name = "ARJUN", value = "")
    public String somethingFromArjun(){
        return "Magic from Arjun";
    }
     */
}
