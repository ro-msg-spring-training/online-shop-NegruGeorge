package com.example.shop.Entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Product extends EntittyId {

    private String Namee;
    private String Description;
    private  BigDecimal Price;
    private Double Weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IdCategory")
    private ProductCategory productCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IdSupplier")
   private  Supplier supplier;
    public Product(ProductCategory prod,Supplier sup)
    {
        this.productCategory = prod;
        this.supplier = sup;
    }





}
