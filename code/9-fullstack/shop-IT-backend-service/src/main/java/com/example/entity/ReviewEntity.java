package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int stars;
    private String body;
    private String author;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

}
