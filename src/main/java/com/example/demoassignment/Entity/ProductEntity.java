package com.example.demoassignment.Entity;

import jakarta.persistence.*;

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
    private String description;
    private String introduce;
    private String preserve;
    private String img;
    @OneToOne(mappedBy = "")
    private TypeProductEntity typeProductEntity;

}
