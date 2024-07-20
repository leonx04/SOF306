package com.example.responseentity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
@Data
@Entity
@Table(name = "Categories", schema = "dbo", catalog = "J6Store")
public class CategoriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    List<ProductsEntity> products;

}
