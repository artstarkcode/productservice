package com.arjun.productservice.controllers;

import com.arjun.productservice.dtos.CreateProductRequestDto;
import com.arjun.productservice.dtos.CreateProductResponseDto;
import com.arjun.productservice.models.Product;
import com.arjun.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


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
    public void getAllProducts(){
        /*
        List<Product> productList = productService.getAllProducts();
        GetAllProductsResponseDto response =  new GetAllProductsResponseDto();
        List<GetProductDto> getProductResponseDtos = new ArrayList<>();
        for (Product product : productList){
            getProductResponseDtos.add(GetProductDto.fromProduct(product));
        }
        response.setProducts(getProductResponseDtos);
        return null;*/
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
