package com.aicamp.analyze.service;



import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.aicamp.analyze.dto.TitanicDTO;
import com.aicamp.analyze.dto.TitanicResponse;

@Service
public class TitanicService {
    //외부와 통신할 때 사용하는 Spring의 비동기 클라이언트
    //pom.xml에 webflux 추가하기!
    private WebClient webClient;

    public TitanicService(){
        this.webClient = WebClient.builder()
        .baseUrl("http://127.0.0.1:8000/")
        .defaultHeader(HttpHeaders.CONTENT_TYPE
            ,MediaType.APPLICATION_JSON_VALUE)
        .build();
    }
    public TitanicResponse analyzeTitanic(TitanicDTO titanicDTO){
         return webClient.post()
                .uri("data")
                .bodyValue(titanicDTO)
                .retrieve()
                .bodyToMono(TitanicResponse.class)
                .block();

    /*.post() : post방식으로 데이터 전송
      .uri()  : 전송할 주소
      .bodyValue() : 보낼 데이터
      .retrieve() : 응답 받을 대기
      .bodyToMono() : class파일로 데이터를 받겠다. 
      .block() : 동기상태로 변경
      */
    

    }
    
    }
    

