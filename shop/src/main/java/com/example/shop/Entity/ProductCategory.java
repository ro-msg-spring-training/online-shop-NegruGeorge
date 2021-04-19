package com.example.shop.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productcategory")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder

public class ProductCategory extends EntittyId {
    @Column(name ="Namee")
    private String Name;
    private String Description;


}
