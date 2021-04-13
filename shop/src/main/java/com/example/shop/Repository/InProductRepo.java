package com.example.shop.Repository;


import com.example.shop.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InProductRepo  extends JpaRepository<Product,Integer> {
}
