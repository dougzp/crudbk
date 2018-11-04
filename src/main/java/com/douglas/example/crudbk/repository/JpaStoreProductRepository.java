package com.douglas.example.crudbk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.example.crudbk.entities.StoreProduct;

public interface JpaStoreProductRepository extends JpaRepository<StoreProduct, Long>{
}
