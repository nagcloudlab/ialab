package com.example.api.dto;

import lombok.Data;

@Data
public class FeedbackDto {
    private int id;
    private String name;
    private String trainerName;
    private String feedback;
}
