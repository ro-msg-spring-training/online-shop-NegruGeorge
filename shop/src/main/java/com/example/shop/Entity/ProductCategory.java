package com.example.shop.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtcategory")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class ProductCategory extends EntittyId {
    private String Name;
    private String Description;


}
