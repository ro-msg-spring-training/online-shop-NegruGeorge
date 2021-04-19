package com.example.shop.Entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Product extends EntittyId {

    private String Namee;
    private String Description;
    private  BigDecimal Price;
    private Double Weight;
    private String ImageURL;

    @ManyToOne
    @JoinColumn(name = "IdCategory")
    private ProductCategory productCategory;
    @ManyToOne
    @JoinColumn(name="IdSupplier")
    private  Supplier supplier;
//    public Product(ProductCategory prod,Supplier sup)
//    {
//        this.productCategory = prod;
//        this.supplier = sup;
//    }





}
