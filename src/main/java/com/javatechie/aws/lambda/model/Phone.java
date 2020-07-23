package com.javatechie.aws.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    private String modelId;
    private String modelName;
    private String brandName;
}
