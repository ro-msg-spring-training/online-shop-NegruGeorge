package com.example.shop.strategy;

import com.example.shop.Entity.Location;
import com.example.shop.Entity.Product;
import com.example.shop.Entity.Stock;
import com.example.shop.Repository.InLocationRepo;
import com.example.shop.Repository.InProductRepo;
import com.example.shop.Repository.InStockRepo;
import com.example.shop.dto.OrderDetailDTO;
import com.example.shop.dto.OrderrObjDTO;
import com.example.shop.dto.StockDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class SingleLocationStrategy implements  InStrategy{

    private  InStockRepo stockRepo;
    private InLocationRepo locationRepo;
    private InProductRepo productRepo;



    @Override
    public List<StockDTO> findstocks(OrderrObjDTO orderrObjDTO) {
        System.out.println(orderrObjDTO);
        List<StockDTO> stockDTOS = new ArrayList<>();
        List<Stock> stocks;

        List<Location> location_list = locationRepo.findAll();
        System.out.println(location_list);
        orderrObjDTO.getOrderDetailDTO_List().forEach(x-> System.out.println(x));
        boolean gasit;
        for (Location loc : location_list) {
            for (OrderDetailDTO orderDetailDTO : orderrObjDTO.getOrderDetailDTO_List()) {

                Product p = productRepo.findById(orderDetailDTO.getIdProduct()).orElse(null);
                stocks = stockRepo.findByProductAndQuantityGreaterThanEqualAndLocation(p,
                        orderDetailDTO.getQuantity(),
                        loc);

                System.out.println("product " + p);
                System.out.println("loc " + loc);
                System.out.println("stock " + stocks);
                System.out.println("quant + " + orderDetailDTO.getQuantity());
                if (stocks.isEmpty() || stocks == null) {
                    break;
                }

                stockDTOS.add(StockDTO.builder()
                        .idLocation(stocks.get(0).getStockId().getIdLocation())
                        .idProduct(stocks.get(0).getStockId().getIdProduct())
                        .quantity(orderDetailDTO.getQuantity())
                        .build());

            }
            System.out.println("ss " + stockDTOS);
            if (!stockDTOS.isEmpty())
                return stockDTOS;
        }
        throw new RuntimeException("localStrategy does not work");
    }
}
