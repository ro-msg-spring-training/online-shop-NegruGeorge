package com.example.shop.Repository;

import com.example.shop.Entity.Location;
import com.example.shop.Entity.Product;
import com.example.shop.Entity.Stock;
import com.example.shop.Entity.StockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface InStockRepo  extends JpaRepository<Stock, StockId> {

    //List<Stock> findStockByProductAndQuantityGreaterThanEqualAndLocation(Integer idProduct, Integer quantity, Integer idLocation);
//  Stock findStockByStockId
   // Stock findStockByProductIdAndQuantityGreaterThanEqualAndLocationId(Integer idProduct, Integer quantity, Integer idLocation);
    //Stock findStockByProductAndQuantityGreaterThanEqualAndLocation(Integer Product, Integer Quantity, Integer Location);

   List<Stock> findByProductAndQuantityGreaterThanEqualAndLocation(Product product, Integer quantity, Location idLocation);
   List<Stock> findByProductAndQuantityGreaterThanEqualOrderByQuantityDesc(Product product,Integer quantity);

}
