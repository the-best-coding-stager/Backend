package com.example.demo.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.model.Foo;

public interface IFooDao extends JpaRepository<Foo, Long> {
    
}