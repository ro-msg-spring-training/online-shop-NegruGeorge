package com.example.shop.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stock{

    @EmbeddedId
    private StockId id;


    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name="IdProduct")
    Product product;

    @ManyToOne
    @MapsId("idLocation")
    @JoinColumn(name="IdLocation")
    Location location;

    Integer quantity;

    public Stock(Product p, Location l)
    {
        this.product = p;
        this.location=l;
    }


}
