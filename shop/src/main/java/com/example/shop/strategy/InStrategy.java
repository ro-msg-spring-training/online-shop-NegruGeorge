package com.example.shop.strategy;


import com.example.shop.dto.OrderrObjDTO;
import com.example.shop.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InStrategy {
    List<StockDTO> findstocks(OrderrObjDTO orderrObjDTO);
}
