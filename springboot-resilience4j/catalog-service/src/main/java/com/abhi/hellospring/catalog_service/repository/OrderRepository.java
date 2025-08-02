package com.abhi.hellospring.catalog_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.hellospring.catalog_service.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findByCategory(String category);


}