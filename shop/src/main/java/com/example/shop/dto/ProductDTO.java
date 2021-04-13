package com.example.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDTO implements Serializable {
    private Integer IdProduct;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;


}
