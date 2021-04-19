package com.example.shop.converter;

import com.example.shop.Entity.Address;
import com.example.shop.Entity.Customer;
import com.example.shop.Entity.Location;
import com.example.shop.Entity.Orderr;
import com.example.shop.dto.*;
import org.springframework.stereotype.Component;

@Component
public class OrderrConverter implements InConverter<Orderr, OrderDTO>{

    @Override
    public OrderDTO entityToDto(Orderr entity) {
        Address address = entity.getAddress();
        AddressDTO add = AddressDTO
                .builder()
                .county(address.getCounty())
                .city(address.getCity())
                .country(address.getCountry())
                .streetAddress(address.getStreetAddress())
                .build();

        Customer customer = entity.getCustomer();
        CustomerDTO cust = CustomerDTO.builder()
//                .emailAddress(customer.getEmailAddress())
//                .firstName(customer.getFirstName())
//                .lastName(customer.getLastName())
//                .idCustomer(customer.getId())
//                .username(customer.getUsername())
//                .password(customer.getPassword())

                .build();

        Location location   = entity.getShippedFrom();

        Address loc_address = location.getAddress();
        AddressDTO shippedfrom_add = AddressDTO.builder()
                .streetAddress(loc_address.getStreetAddress())
                .country(loc_address.getCountry())
                .city(loc_address.getCity())
                .county(loc_address.getCounty())
                .build();

        LocationDTO shippedfrom = LocationDTO.builder()
                .addressDTO(shippedfrom_add)
                .name(location.getNamee())
                .idLocation(location.getId())
                .build();

        OrderDTO orderDTO = OrderDTO.builder()
                .idOrderr(entity.getId())
                .createdAt(entity.getCreatedAt())
                .customerDTO(cust)
                .ShippedFrom(shippedfrom)
                .addressDTO(add)
                .build();

        return orderDTO;

    }

    @Override
    public Orderr DTOToEntity(OrderDTO orderDTO) {
        return null;
    }
}
