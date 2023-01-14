package com.gestion.service.api.dataaccess.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "qte_stock")
    private int qte_stock;

    @Column(name = "sale")
    private int sale;

    @Column(name = "sale_amount")
    private float sale_amount;

    @Column(name = "price")
    private float price;

    @Column(name = "image")
    private String image;

}
