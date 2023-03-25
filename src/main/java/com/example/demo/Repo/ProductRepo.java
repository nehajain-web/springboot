package com.example.demo.Repo;

import com.example.demo.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<product,Integer> {
}
