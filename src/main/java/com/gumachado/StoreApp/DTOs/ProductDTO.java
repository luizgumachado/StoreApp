package com.gumachado.StoreApp.DTOs;

import lombok.Data;

@Data
public abstract class ProductDTO {
    private String name;
    private double price;
    private int quantityInStock;
}
