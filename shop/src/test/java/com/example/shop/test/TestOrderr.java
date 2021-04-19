package com.example.shop.test;


import com.example.shop.Entity.Location;
import com.example.shop.Entity.Product;
import com.example.shop.Entity.Stock;
import com.example.shop.Repository.InLocationRepo;
import com.example.shop.Repository.InProductRepo;
import com.example.shop.Repository.InStockRepo;
import com.example.shop.ShopApplication;
import com.example.shop.controller.OrderController;
import com.example.shop.dto.AddressDTO;
import com.example.shop.dto.OrderDetailDTO;
import com.example.shop.dto.OrderrObjDTO;
import com.example.shop.service.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ShopApplication.class)
@ActiveProfiles("test")
public class TestOrderr {

    @Autowired
    private InProductRepo productRepo;
    @Autowired
    private InStockRepo stockRepo;

    @Autowired
    private InLocationRepo locationRepo;

    @Autowired
    private OrderServiceImpl orderService;






    private Product p1 = Product.builder().Namee("p1").build();
    private Product p3 = Product.builder().Namee("p3").build();

    private Product p2 = Product.builder().Namee("p2").build();
    private Product p4 = Product.builder().Namee("p4").build();

    private Location loc1 = Location.builder().Namee("loc1").build();
    private Location loc2 = Location.builder().Namee("loc2").build();


    private Stock s1 = Stock.builder().location(loc1).product(p1).quantity(15).build();
    private Stock s2 = Stock.builder().location(loc2).product(p2).quantity(20).build();
    private Stock s3 = Stock.builder().location(loc1).product(p3).quantity(13).build();



    @Before
    public void init(){
        productRepo.save(p1);
        productRepo.save(p2);
        productRepo.save(p3);
        productRepo.save(p4);
        locationRepo.save(loc1);
        locationRepo.save(loc2);

        stockRepo.save(s1);
        stockRepo.save(s2);
        stockRepo.save(s3);
    }


    @Test
    public void create_order_return_order()
    {

        OrderrObjDTO orderrObjDTO = new OrderrObjDTO();
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        orderDetailDTOS.add(OrderDetailDTO.builder().idProduct(p1.getId()).quantity(2).build());
        orderDetailDTOS.add(OrderDetailDTO.builder().idProduct(p2.getId()).quantity(3).build());
        orderrObjDTO.setOrderDetailDTO_List(orderDetailDTOS);

        orderrObjDTO.setTime(LocalDate.now());
        orderrObjDTO.setAddressDTO(AddressDTO.builder().streetAddress("acasa").country("Romania").county("BH").city("Oradea").build());

        assertFalse(orderService.addOrders(orderrObjDTO).isEmpty());
    }

}
