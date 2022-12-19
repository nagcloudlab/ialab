package com.example.service;

import com.example.api.dto.FeedbackDto;
import com.example.entity.Feedback;
import com.example.repository.JpaFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    private final JpaFeedbackRepository feedbackRepository;

    @Override
    public FeedbackDto save(FeedbackDto FeedbackDto) {
        Feedback feedbackEntity = new Feedback();
        feedbackEntity.setName(FeedbackDto.getName());
        feedbackEntity.setTrainerName(FeedbackDto.getTrainerName());
        feedbackEntity.setFeedback(FeedbackDto.getFeedback());
        Feedback feedback = feedbackRepository.save(feedbackEntity);

        FeedbackDto feedbackResponse = new FeedbackDto();
        feedbackResponse.setId(feedback.getId());
        feedbackResponse.setName(feedback.getName());
        feedbackResponse.setTrainerName(feedback.getTrainerName());
        feedbackResponse.setFeedback(feedback.getFeedback());
        return feedbackResponse;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FeedbackDto> getAll() {
        Iterable<Feedback> feedbackIterable = feedbackRepository.findAll();
        List<FeedbackDto> feedbackResponseList = new ArrayList<>();
        for (Feedback feedback : feedbackIterable) {
            FeedbackDto feedbackResponse = new FeedbackDto();
            feedbackResponse.setId(feedback.getId());
            feedbackResponse.setName(feedback.getName());
            feedbackResponse.setTrainerName(feedback.getTrainerName());
            feedbackResponse.setFeedback(feedback.getFeedback());
            feedbackResponseList.add(feedbackResponse);
        }
        return feedbackResponseList;
    }

}
