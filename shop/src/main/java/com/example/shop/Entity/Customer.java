package com.example.shop.Entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Customer extends EntittyId{

    private String FirstName;
    private String LastName;
    private String Username;
    private String Password;
    private String EmailAddress;


}
