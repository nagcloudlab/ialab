package com.example.repository;

import com.example.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {

    @Query("from ReviewEntity review where review.product.id=:productId")
    Iterable<ReviewEntity> findByProductId(int productId);
}
