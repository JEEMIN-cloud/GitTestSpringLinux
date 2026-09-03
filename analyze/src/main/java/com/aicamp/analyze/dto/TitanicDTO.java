package com.aicamp.analyze.dto;

import lombok.Data;

@Data //getter, setter, constructor
public class TitanicDTO {
    
    private int pclass;
    private float age;
    private String sex;
    private int ssa;
    private int pca;
    private float fare;

}
