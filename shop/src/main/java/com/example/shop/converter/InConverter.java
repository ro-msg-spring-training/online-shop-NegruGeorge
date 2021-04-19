package com.example.shop.converter;

public interface InConverter <Ent,DTO>{
    DTO entityToDto(Ent entity);
    Ent DTOToEntity(DTO dto);

}
