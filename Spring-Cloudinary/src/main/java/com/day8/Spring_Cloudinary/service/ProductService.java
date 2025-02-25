package com.day8.Spring_Cloudinary.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.day8.Spring_Cloudinary.entity.Product;
import com.day8.Spring_Cloudinary.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    private final Cloudinary cloudinary;

    @Autowired
    public ProductService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public Product addProduct(Product product, MultipartFile imageFile) {
        try {
            // Upload image to Cloudinary
            Map<String, Object> uploadResult = cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("url");
            product.setImageUrl(imageUrl); // Set the image URL

            // Save product in the database
            return productRepo.save(product);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image", e);
        }
    }

    public List<Product> listProduct(){
        return productRepo.findAll();
    }
}
