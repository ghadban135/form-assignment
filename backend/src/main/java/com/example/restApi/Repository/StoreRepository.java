package com.example.restApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restApi.Models.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
    
}
