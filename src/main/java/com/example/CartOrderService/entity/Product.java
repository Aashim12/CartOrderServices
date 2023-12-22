package com.example.CartOrderService.entity;

import lombok.Data;

@Data
public class Product {

    private String productId;
    private String productName;
    private String productDescription;
    private String productImageUrl;
    private String productBrand;
    private Category category;

}
