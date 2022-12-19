package com.example.repository;

import com.example.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFeedbackRepository extends JpaRepository<Feedback,Integer> {
}
