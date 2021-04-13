package com.example.shop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class OrderDetail  {

    @EmbeddedId
    private OrderDetailId id;


    @ManyToOne
    @MapsId("idOrderr")
    @JoinColumn(name="IdOrderr")
    Orderr orderr;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name="IdProduct")
    Product product;

    Integer Quantity;

    public OrderDetail(Orderr orderr, Product product) {
        this.orderr = orderr;
        this.product = product;
    }


}
