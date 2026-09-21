package com.aicamp.analyze.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import com.aicamp.analyze.dto.DogCatResponse;

@Service
public class DogApiService {
    private final WebClient webClient;
    public DogApiService(){
        this.webClient = WebClient.builder()
        .baseUrl("http://127.0.0.1:8000")
        .build();
    }
public DogCatResponse sendImage(MultipartFile file){
    //file 보내기 위한 코드
    MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
    formData.add("file", file.getResource());

    return webClient.post()
    .uri("/predict")
    .contentType((MediaType.MULTIPART_FORM_DATA))
    .bodyValue(formData)
    .retrieve()
    .bodyToMono(DogCatResponse.class)
    .block();
    
}
    
}
