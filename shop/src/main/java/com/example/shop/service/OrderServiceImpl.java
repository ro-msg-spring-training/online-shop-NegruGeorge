package com.example.shop.service;

import com.example.shop.Entity.*;
import com.example.shop.Repository.*;
import com.example.shop.converter.AddressConverter;
import com.example.shop.converter.OrderrConverter;
import com.example.shop.dto.OrderDTO;
import com.example.shop.dto.OrderrObjDTO;
import com.example.shop.dto.StockDTO;
import com.example.shop.strategy.InStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements InService<OrderDTO, Orderr> {
    private final InOrderrRepo orderrRepo;
    private final InOrderDetailsRepo orderDetailsRepo;
    private final InStockRepo stockRepo;
    private final InStrategy strategy;
    private final AddressConverter addressConverter;
    private final InLocationRepo locationRepo;
    private final InProductRepo productRepo;
    private final OrderrConverter orderrConverter;

    @Autowired
    public OrderServiceImpl(InOrderrRepo orderrRepo, InOrderDetailsRepo orderDetailsRepo, InStockRepo stockRepo, InStrategy strategy, AddressConverter addressConverter, InLocationRepo locationRepo, InProductRepo productRepo, OrderrConverter orderrConverter) {
        this.orderrRepo = orderrRepo;
        this.orderDetailsRepo = orderDetailsRepo;
        this.stockRepo = stockRepo;
        this.strategy = strategy;
        this.addressConverter = addressConverter;
        this.locationRepo = locationRepo;
        this.productRepo = productRepo;
        this.orderrConverter = orderrConverter;

    }


    public List<OrderDTO> addOrders(OrderrObjDTO orderrObjDTO)
    {
         List<StockDTO> stocks = strategy.findstocks(orderrObjDTO);
        List<OrderDTO> orderDTOS = new ArrayList<>();


        System.out.println(stocks);
        Address address  = addressConverter.DTOToEntity(orderrObjDTO.getAddressDTO());

        for(StockDTO stock:stocks)
        {
                Orderr orderr = Orderr.builder()
                        .ShippedFrom(locationRepo.findById(stock.getIdProduct()).orElse(null))
                        .CreatedAt(orderrObjDTO.getTime())
                        .address(address)
                        .build();

                orderrRepo.save(orderr);

            OrderDetailId orderDetailId  = OrderDetailId.builder()
                                        .idProduct(orderr.getId())
                                        .idOrderr(stock.getIdProduct())
                                        .build();

            OrderDetail orderDetail = OrderDetail.builder()
                    .id(orderDetailId)
                    .orderr(orderr)
                    .product(productRepo.findById(stock.getIdProduct()).orElse(null))
                    .Quantity(stock.getQuantity())
                    .build();

            System.out.println(orderDetail);
            orderDetailsRepo.save(orderDetail);

            System.out.println(stock.getIdProduct());
            System.out.println(stock.getIdLocation());
            System.out.println(stock.getQuantity());

            List<Stock> findStocks_list = stockRepo
                    .findByProductAndQuantityGreaterThanEqualAndLocation
                            (
                            productRepo.findById(stock.getIdProduct()).orElse(null),
                            stock.getQuantity(),
                            locationRepo.findById(stock.getIdLocation()).orElse(null)
                            );

            findStocks_list.get(0).setQuantity(findStocks_list.get(0).getQuantity() - stock.getQuantity());
            stockRepo.save(findStocks_list.get(0));

            System.out.println("aicia " + orderr);
        orderDTOS.add(orderrConverter.entityToDto(orderr));
        }

        return orderDTOS;
    }

    @Override
    public List<OrderDTO> getALL() {
        return null;
    }

    @Override
    public void addProduct(OrderDTO productDTO) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(OrderDTO newproductDTO, Integer id) {

    }

    @Override
    public OrderDTO findOne(Integer id) {
        return null;
    }

    @Override
    public OrderDTO ENTtoDTO(Orderr p) {
        return null;
    }

    @Override
    public Orderr DTOtoENT(OrderDTO p) {
        return null;
    }
}
