package com.example.shop.Repository;


import com.example.shop.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InCustomerRepo extends JpaRepository<Customer,Integer> {
}
