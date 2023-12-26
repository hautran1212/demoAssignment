package com.example.demoassignment.Entity;

import com.example.demoassignment.Controller.ImgProductEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private int promotion;
    private String description;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ImgProductEntity> imgProductEntities;

    public List<ImgProductEntity> getImgProductEntities() {
        return imgProductEntities;
    }

    public void setImgProductEntities(List<ImgProductEntity> imgProductEntities) {
        this.imgProductEntities = imgProductEntities;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToOne()
    @JoinColumn(name = "cate_id")
    private Category category;

}
