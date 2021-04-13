package com.example.shop.Entity;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Location extends EntittyId {
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "country", column = @Column(name = "Country")),
            @AttributeOverride( name = "city", column = @Column(name = "City")),
            @AttributeOverride( name = "county", column = @Column(name = "County")),
    })
    private Address address;

    public Location(Address address) {
        this.address = address;
    }




}
