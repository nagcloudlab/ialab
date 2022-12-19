package com.example.api.dto;

import lombok.Data;

@Data
public class FeedbackResponse {

    private int id;
    private String name;
    private String trainerName;
    private String feedback;

}
