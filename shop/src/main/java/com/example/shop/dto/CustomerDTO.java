package com.example.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO implements Serializable {
    private Integer idCustomer;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;

}
