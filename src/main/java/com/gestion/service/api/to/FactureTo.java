package com.gestion.service.api.to;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FactureTo {

    private int id;

    private int user_id;

    private int product_id;

    private String user_fullName;

    private String product_name;

    private String creation_Date;

    private int product_qte;

    private float total_price;
}
