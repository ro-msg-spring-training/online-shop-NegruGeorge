package com.example.shop.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Stock{

    @EmbeddedId
    private StockId stockId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProduct")
    @JoinColumn(name="IdProduct")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idLocation")
    @JoinColumn(name="IdLocation")
    private Location location;

   private Integer quantity;

    public Stock(Product p, Location l)
    {
        this.product = p;
        this.location=l;
    }


}
