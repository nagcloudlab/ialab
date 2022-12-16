package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class ProductEntity {

    @Id
    private int id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private boolean available;


}
