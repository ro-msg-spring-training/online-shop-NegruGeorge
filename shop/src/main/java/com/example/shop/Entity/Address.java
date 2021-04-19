package com.example.shop.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder
public class Address {
    private String country;
    private String city;
    private String county;
    private String streetAddress;

}
