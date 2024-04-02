package com.example.projectback.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


    private String title;


    private String description;


    private int price;

    @Column(name="discounted_price")
    private int discountedPrice;

    @Column(name="discounted_percent")
    private int discountedPercent;

    private int quantity;
    private String brand;
    private String color;

    @Embedded
    @ElementCollection
    @Column(name="sizes")
    private Set<Size> sizes=new HashSet<>();

    @Column(name="image_url")
    private String imageUrl;

    @OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<Rating> ratings=new ArrayList<>();

    @OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<Review> reviews=new ArrayList<>();

    @Column(name="num_ratings")
    private int numRatings;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;

    public Product(Long id, String title, String description, int price, int discountedPrice, int discountedPercent, int quantity, String brand, String color, Set<Size> sizes, String imageUrl, List<Rating> ratings, List<Review> reviews, int numRatings, Category category, LocalDateTime createdAt) {
        Id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.discountedPercent = discountedPercent;
        this.quantity = quantity;
        this.brand = brand;
        this.color = color;
        this.sizes = sizes;
        this.imageUrl = imageUrl;
        this.ratings = ratings;
        this.reviews = reviews;
        this.numRatings = numRatings;
        this.category = category;
        this.createdAt = createdAt;
    }

    private LocalDateTime createdAt;

    public Product(){

    }

}
