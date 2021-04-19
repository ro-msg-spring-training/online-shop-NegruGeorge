package com.example.shop.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductDTO implements Serializable {
    private Integer IdProduct;
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private Integer idCategory;
    private String ProductCategoryName;
    private String ProductCategoryDescription;
    private Integer IdSupplier;
    private String SupplierName;
    private String imageUrl;

}
