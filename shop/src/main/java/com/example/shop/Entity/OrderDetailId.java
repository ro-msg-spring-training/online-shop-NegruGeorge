package com.example.shop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderDetailId implements Serializable {
    @Column(name="IdOrderr")
    private Integer idOrderr;
    @Column(name="IdProduct")
    private Integer idProduct;

}
