package com.example.responseentity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
@Data
@Entity
@Table(name = "Products", schema = "dbo", catalog = "J6Store")
public class ProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Image")
    private String image;

    @Column(name = "Price")
    private double price;
    @Temporal(TemporalType.DATE)
    @Column(name = "CreateDate")
    private Date createDate = new Date( new java.util.Date().getTime());

    @Column(name = "Available")
    private boolean available;
    @ManyToOne
    @JoinColumn (name = "CategoryId")
    private CategoriesEntity category;
    @JsonIgnore
    @OneToMany(mappedBy = "productsByProductId")
    List<OrderDetailsEntity> orderDetailsById;


}
