package com.gestion.service.api.to;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductTo {

    private int id;
    private String name;
    private String description;
    private int qte_stock;
    private int sale;
    private float sale_amount;
    private float price;
    private String image;
}
