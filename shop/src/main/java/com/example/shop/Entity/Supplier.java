package com.example.shop.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="supplier")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

public class Supplier extends EntittyId {
    private String Namee;


}
