package com.example.shop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO implements Serializable {
        private Integer idOrderr;


        private LocationDTO ShippedFrom;

        private CustomerDTO customerDTO;

        private LocalDate createdAt;
        private AddressDTO addressDTO;




}
