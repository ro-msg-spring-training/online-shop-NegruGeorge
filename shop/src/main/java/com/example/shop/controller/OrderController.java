package com.example.shop.controller;


import com.example.shop.Entity.Product;
import com.example.shop.Repository.InProductRepo;
import com.example.shop.dto.AddressDTO;
import com.example.shop.dto.OrderDTO;
import com.example.shop.dto.OrderDetailDTO;
import com.example.shop.dto.OrderrObjDTO;
import com.example.shop.service.OrderServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController

public class OrderController {
    private final OrderServiceImpl srv;
    private final InProductRepo productRepo;

    public OrderController(OrderServiceImpl srv, InProductRepo productRepo) {
        this.srv = srv;
        this.productRepo = productRepo;
    }


    @GetMapping("/orders")
    public List<OrderDTO> makeOrderr()
    {
        AddressDTO addressDTO = AddressDTO.builder()
                .county("bihg")
                .city("or")
                .country("rom")
                .streetAddress("caz")
                .build();

        Product p1 = productRepo.findById(1).orElse(null);
        Product p2 = productRepo.findById(2).orElse(null);
        Product p3 = productRepo.findById(3).orElse(null);
        Product p4 = productRepo.findById(4).orElse(null);

        List<OrderDetailDTO> orList = new ArrayList<>();

        OrderDetailDTO ord1 = OrderDetailDTO.builder()
                            .idProduct(1)
                            .quantity(10)
                             .build();
        OrderDetailDTO ord2 = OrderDetailDTO.builder()
                            .idProduct(1)
                            .quantity(30)
                            .build();
        OrderDetailDTO ord3 = OrderDetailDTO.builder()
                .idProduct(1)
                .quantity(3)
                .build();

        orList.add(ord1);
        orList.add(ord2);
        orList.add(ord3);

        OrderrObjDTO orderrObjDTO = OrderrObjDTO.builder()
                                    .addressDTO(addressDTO)
                                    .time(LocalDate.now())
                                    .orderDetailDTO_List(orList)
                                    .build();

        List<OrderDTO> dto  = srv.addOrders(orderrObjDTO);
        System.out.println("am trimis");
        System.out.println(dto);
        return dto;
    }


}
