package com.aicamp.analyze.controller;

import com.aicamp.analyze.dto.DogCatResponse;
import com.aicamp.analyze.service.DogApiService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DogController {
    
    private final DogApiService dogApiService;

    DogController(DogApiService dogApiService) {
        this.dogApiService = dogApiService;
    }

    @PostMapping("/predict")
    public DogCatResponse predict(@RequestParam MultipartFile file) {
     
    dogApiService.sendImage(file);
        
        return dogApiService.sendImage(file);
    }
    
}
