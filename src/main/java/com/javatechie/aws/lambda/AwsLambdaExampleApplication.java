package com.javatechie.aws.lambda;

import com.javatechie.aws.lambda.model.Phone;
import com.javatechie.aws.lambda.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class AwsLambdaExampleApplication {

    @Autowired
    private PhoneRepository repository;

    @Bean
    public Supplier<List<Phone>> phones() {
        return () -> repository.findAllPhones();
    }

    @Bean
    public Function<String, List<Phone>> findPhonesByBrandName() {
        return (brandName) -> repository.findAllPhones()
                .stream().filter(phone -> phone.getBrandName().equals(brandName))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(AwsLambdaExampleApplication.class, args);
    }

}
