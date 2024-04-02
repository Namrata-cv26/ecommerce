package com.example.projectback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Rating {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_id",nullable=false)
    private Product product;

    @Column(name="rating")
    private double rating;
    private LocalDateTime createdAt;
}
