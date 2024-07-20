package com.example.responseentity.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
@Data
@Entity
@Table(name = "OrderDetails", schema = "dbo", catalog = "J6Store")
public class OrderDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @Column(name = "OrderId")
    private long orderId;
    @Basic
    @Column(name = "ProductId")
    private int productId;
    @Basic
    @Column(name = "Price")
    private double price;
    @Basic
    @Column(name = "Quantity")
    private int quantity;

}
