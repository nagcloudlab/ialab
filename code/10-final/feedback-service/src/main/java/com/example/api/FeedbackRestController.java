package com.example.api;

import com.example.api.dto.FeedbackDto;
import com.example.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/feedbacks")
public class FeedbackRestController {

    private final FeedbackService feedbackService;

    // POST api/v1/feedbacks
    // Content-Type: application/json
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createFeedback(@RequestBody FeedbackDto feedbackDto) {
        FeedbackDto feedbackResponse = feedbackService.save(feedbackDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackResponse);
    }

    // GET api/v1/feedbacks
    // Accept: application/json
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAll());
    }

}
