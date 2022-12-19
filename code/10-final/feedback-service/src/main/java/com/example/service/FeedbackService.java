package com.example.service;

import com.example.entity.Feedback;
import org.springframework.transaction.annotation.Transactional;

public interface FeedbackService {
    void save(Feedback feedback);

    @Transactional(readOnly = true)
    Iterable<Feedback> getAll();
}
