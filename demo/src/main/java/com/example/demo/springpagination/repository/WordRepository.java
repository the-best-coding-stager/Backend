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
    
    Page<Word> findByWriterId(String writerId, Pageable pageReq);
    
    Page<Word> findByNameContaining(String name, Pageable pageReq);
    
    default Page<Word> findPopular(Pageable pageReq) {
    	return findTop10ByOrderByLikesDesc(pageReq);
    }
    
    default Page<Word> findNewest(Pageable pageReq) {
    	return findTop10ByOrderByDateDesc(pageReq);
    }

    default Page<Word> findByUser(User user, Pageable pageReq) {
        return findByWriterId(user.getUser_id(), pageReq);
    }

    default Page<Word> findName(String name, Pageable pageReq) {
        return findByNameContaining(name, pageReq);
    }
    
}