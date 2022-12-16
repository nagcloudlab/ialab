package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int stars;
    private String body;
    private String author;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

}
