package com.example.restApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restApi.Models.Form;

public interface FormRepository extends JpaRepository<Form, Long> {
    
}
