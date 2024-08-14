package com.nitin.spring_data_jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nitin.spring_data_jpa.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
    
}
