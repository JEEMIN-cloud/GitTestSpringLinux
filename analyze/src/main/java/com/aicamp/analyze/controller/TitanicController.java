package com.aicamp.analyze.controller;

import com.aicamp.analyze.service.TitanicService;
import org.springframework.web.bind.annotation.RestController;

import com.aicamp.analyze.dto.TitanicDTO;
import com.aicamp.analyze.dto.TitanicResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TitanicController {

    private final TitanicService titanicService;

    TitanicController(TitanicService titanicService) {
        this.titanicService = titanicService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<TitanicResponse>  analyze(@RequestBody TitanicDTO dto) {

    TitanicResponse res =titanicService.analyzeTitanic(dto);
    
      return ResponseEntity.ok(res);
    }
    
    
}
