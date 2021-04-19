package com.example.shop.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class EntittyId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;



}
