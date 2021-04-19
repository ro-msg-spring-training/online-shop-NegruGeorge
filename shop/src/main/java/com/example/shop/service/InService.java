package com.example.shop.service;

import com.example.shop.dto.ProductDTO;

import java.util.List;

public interface InService <DTO,ENT> {
    List<DTO> getALL();
    void addProduct(DTO productDTO);

    void delete(Integer id);
    void update(DTO newproductDTO,Integer id);
    DTO findOne(Integer id);

    DTO ENTtoDTO(ENT p);
    ENT DTOtoENT(DTO p);
}
