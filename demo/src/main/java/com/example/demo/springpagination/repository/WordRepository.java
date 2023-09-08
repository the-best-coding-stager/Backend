package com.example.demo.springpagination.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.springpagination.model.Word;
import com.example.demo.springpagination.model.User;

public interface WordRepository extends JpaRepository<Word, Long> {
    
    Page<Word> findAll(Pageable pageReq);
    
    Page<Word> findTop10ByOrderByLikesDesc(Pageable pageReq);
    
    Page<Word> findTop10ByOrderByDateDesc(Pageable pageReq);
    
    default Page<Word> findPopular(Pageable pageReq) {
    	return findTop10ByOrderByLikesDesc(pageReq);
    }
    
    default Page<Word> findNewest(Pageable pageReq) {
    	return findTop10ByOrderByDateDesc(pageReq);
    }

    @Query(value = "SELECT * FROM words WHERE writer_id=:writer_id", nativeQuery = true)
    Page<Word> findByUserWords(@Param("writer_id") String writer_id, Pageable pageReq);

    default Page<Word> findByUser(User user, Pageable pageReq) {
        return findByUserWords(user.getUser_id(), pageReq);
    }

    @Query(value = "SELECT * FROM words WHERE name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    Page<Word> findByNameWords(@Param("name") String name, Pageable pageReq);

    default Page<Word> findByName(String name, Pageable pageReq) {
        return findByNameWords(name, pageReq);
    }
    
}