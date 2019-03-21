package com.felipebelgine.cmcourse.dto;

import com.felipebelgine.cmcourse.domain.Product;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private static final long setrialVersionUID = 1L;

    private Integer id;
    private String name;
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(Product obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.price = obj.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
