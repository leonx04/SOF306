package com.example.responseentity.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
@Data
@Entity
@Table(name = "Orders", schema = "dbo", catalog = "J6Store")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @Column(name = "Username")
    private String username;
    @Basic
    @Column(name = "CreateDate")
    private Date createDate;
    @Basic
    @Column(name = "Address")
    private String address;
    @OneToMany(mappedBy = "ordersByOrderId")
    private Collection<OrderDetailsEntity> orderDetailsById;

}
