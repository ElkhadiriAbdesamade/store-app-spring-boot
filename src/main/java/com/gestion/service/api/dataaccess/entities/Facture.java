package com.gestion.service.api.dataaccess.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "factures")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Facture {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "product_id")
    private int product_id;

    @Column(name = "user_fullName")
    private String user_fullName;

    @Column(name = "creation_Date")
    private String creation_Date;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_qte")
    private int product_qte;

    @Column(name = "total_price")
    private float total_price;


}
