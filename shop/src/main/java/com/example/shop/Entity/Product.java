package com.example.shop.Entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Product extends EntittyId {

    String Namee;
    String Description;
    Double Price;
    Double Weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IdCategory")
    ProductCategory productCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IdSupplier")
    Supplier supplier;
    public Product(ProductCategory prod,Supplier sup)
    {
        this.productCategory = prod;
        this.supplier = sup;
    }





}
