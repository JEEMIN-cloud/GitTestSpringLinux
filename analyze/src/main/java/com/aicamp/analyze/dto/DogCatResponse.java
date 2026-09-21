package com.aicamp.analyze.dto;

import lombok.Data;

@Data
public class DogCatResponse {
    private String label;
    private double confidence;
}
