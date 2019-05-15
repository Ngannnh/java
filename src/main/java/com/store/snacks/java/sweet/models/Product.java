package com.store.snacks.java.sweet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ngan nnh on 5/13/2019
 * @project sweet
 */
@Document(collection = "product")
public class Product {
    @Id private String id;
    private String name;
    private int price;
    private String details;

    public Product() {
    }

    public Product(String name, int price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
