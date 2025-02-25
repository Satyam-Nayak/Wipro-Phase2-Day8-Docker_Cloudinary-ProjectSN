package com.day8.Spring_Cloudinary.controller;

import com.day8.Spring_Cloudinary.entity.Product;
import com.day8.Spring_Cloudinary.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(
            @RequestPart("product") String productJson,
            @RequestPart("image") MultipartFile imageFile
    ) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(productJson, Product.class);

        Product createProduct = productService.addProduct(product, imageFile);
        System.out.println("Product Created : " + createProduct);
        return new ResponseEntity<>("Product Added Successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> listProduct(){
        List<Product> allProduct = productService.listProduct();
        return new ResponseEntity<>(allProduct, HttpStatus.OK);
    }

}
