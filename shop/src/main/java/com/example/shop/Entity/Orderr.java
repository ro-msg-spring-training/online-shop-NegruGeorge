package com.example.shop.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class Orderr extends EntittyId {

    @ManyToOne
    @JoinColumn(name="IdShippedFrom")
    private Location ShippedFrom;

    @ManyToOne
    @JoinColumn(name="IdCustomer")
    private Customer customer;
    private LocalDate CreatedAt;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "country", column = @Column(name = "Country")),
            @AttributeOverride( name = "city", column = @Column(name = "City")),
            @AttributeOverride( name = "county", column = @Column(name = "County")),
    })
    private Address address;

//    public Orderr(Location l, Customer c , Address a)
//    {
//        this.ShippedFrom =l;
//        this.customer = c;
//
//        this.address = a;
//    }



}
