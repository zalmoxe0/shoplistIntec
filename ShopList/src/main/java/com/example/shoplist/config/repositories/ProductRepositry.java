package com.example.shoplist.config.repositories;

import com.example.shoplist.config.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

}
