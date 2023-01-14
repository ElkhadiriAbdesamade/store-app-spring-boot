package com.gestion.service.api.to;


import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserTo {

    private int id;
    private String first_name;
    private String last_name;
    private String phone;
    private String address;
    private String country;
    private String email;
    private String password;
    private String role;


}
