package com.example.service;

import com.example.api.dto.FeedbackDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FeedbackService {

    FeedbackDto save(FeedbackDto feedbackDto);

    @Transactional(readOnly = true)
    List<FeedbackDto> getAll();

}
