package com.test.lsy.jpa01.ex17.repository;

import com.test.lsy.jpa01.ex17.domain.Review2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Review2Repository extends JpaRepository<Review2, Long> {
    // JPQL
    @Query("SELECT r FROM Review2 r WHERE r.hotelId = :hotelId ORDER BY r.id DESC")
    List<Review2> findByHotelIdOrderByIdDesc(@Param("hotelId") String hotelId);

    @Query("SELECT COUNT(r) FROM Review2 r WHERE r.hotelId = :hotelId")
    Long countByHotelId(@Param("hotelId") String hotelId);

    @Query("SELECT r FROM Review2 r WHERE r.content LIKE %:keyword%")
    List<Review2> searchByContentKeyword(@Param("keyword")String keyword);
}
