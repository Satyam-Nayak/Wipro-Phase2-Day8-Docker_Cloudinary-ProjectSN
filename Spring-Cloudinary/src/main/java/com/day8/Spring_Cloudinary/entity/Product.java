package com.day8.Spring_Cloudinary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_cloudinary")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String skuCode;
    private String description;
    private Double price;
    private Double discountedPrice;
    private Double quantity;
    //    get it from cloudinary
    private String imageUrl;

    public Product() {
    }

    public Product(String name, String skuCode, String description, Double price, Double discountedPrice, Double quantity, String imageUrl) {
        this.name = name;
        this.skuCode = skuCode;
        this.description = description;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    public Product(Long id, String name, String skuCode, String description, Double price, Double discountedPrice, Double quantity, String imageUrl) {
        this.id = id;
        this.name = name;
        this.skuCode = skuCode;
        this.description = description;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skuCode='" + skuCode + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountedPrice=" + discountedPrice +
                ", quantity=" + quantity +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
