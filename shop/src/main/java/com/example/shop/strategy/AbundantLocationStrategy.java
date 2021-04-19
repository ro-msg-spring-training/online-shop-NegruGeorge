package com.example.shop.strategy;

import com.example.shop.Entity.Stock;
import com.example.shop.Repository.InProductRepo;
import com.example.shop.Repository.InStockRepo;
import com.example.shop.dto.OrderDetailDTO;
import com.example.shop.dto.OrderrObjDTO;
import com.example.shop.dto.StockDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class AbundantLocationStrategy implements InStrategy{
    private InStockRepo stockRepo;
    private InProductRepo productRepo;

    @Override
    public List<StockDTO> findstocks(OrderrObjDTO orderrObjDTO) {
        List<StockDTO> stockDTOS = new ArrayList<>();
        List<Stock> stocks = new ArrayList<>();
    for(OrderDetailDTO orderDetailDTO: orderrObjDTO.getOrderDetailDTO_List() )
    {
        stocks =  stockRepo.findByProductAndQuantityGreaterThanEqualOrderByQuantityDesc(productRepo.findById(orderDetailDTO.getIdProduct()).orElse(null),orderDetailDTO.getQuantity());

        if(stockDTOS.isEmpty())
            throw new RuntimeException("no stocks for this ");
        Stock stock = stocks.get(0);
        stockDTOS.add( StockDTO.builder()
                 .idLocation(stock.getStockId().getIdLocation())
                 .idProduct(stock.getStockId().getIdProduct())
                 .quantity(orderDetailDTO.getQuantity())
                 .build());

    }

        return stockDTOS;
    }
}
