package com.example.shop.converter;

import com.example.shop.Entity.Address;
import com.example.shop.dto.AddressDTO;
import org.springframework.stereotype.Component;


@Component
public class AddressConverter implements  InConverter<Address, AddressDTO> {
    @Override
    public AddressDTO entityToDto(Address entity) {
        return AddressDTO.builder()
                .city(entity.getCity())
                .country(entity.getCountry())
                .county(entity.getCounty())
                .streetAddress(entity.getStreetAddress())
                .build();
    }

    @Override
    public Address DTOToEntity(AddressDTO addressDTO) {
        return Address.builder()
                .city(addressDTO.getCity())
                .county(addressDTO.getCounty())
                .country(addressDTO.getCountry())
                .streetAddress(addressDTO.getStreetAddress())
                .build();
    }
}
