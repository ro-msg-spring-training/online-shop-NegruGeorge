package com.example.shop.Repository;


import com.example.shop.Entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InProductCategoryRepo extends JpaRepository<ProductCategory,Integer> {
}
