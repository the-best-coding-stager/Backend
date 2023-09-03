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

    @Query("SELECT u FROM words u WHERE u.writer_id=:writer_id")
    Page<Word> findByUser(@Param("writer_id") String writer_id, Pageable pageReq);

    default Page<Word> findByUser(User user, Pageable pageReq) {
        return findByUser(user.getName(), pageReq);
    }
    
    @Query("SELECT * FROM words")
    Page<Word> findAll(Pageable pageReq);
    
    @Query("SELECT * FROM words ORDER BY viewcount DESC LIMIT 5")
    Page<Word> findPopular();
    
    @Query("SELECT * FROM words ORDER BY written_date DESC LIMIT 5")
    Page<Word> findNewest();
    
}