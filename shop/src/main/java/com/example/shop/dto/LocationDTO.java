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
public class LocationDTO implements Serializable {
    private Integer idLocation;
    private String name;
    private AddressDTO addressDTO;
}
