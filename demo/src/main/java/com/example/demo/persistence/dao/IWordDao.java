package com.example.demo.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.model.Word;

public interface IWordDao extends JpaRepository<Word, Integer> {

}
