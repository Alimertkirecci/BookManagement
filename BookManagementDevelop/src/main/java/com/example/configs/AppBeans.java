package com.example.configs;

import com.example.repositories.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.security.SecurityUtil;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppBeans {

    int i = 0;
    @Bean(name = "objModelMapper")
    public ModelMapper modelMapper() {
        System.out.println("objModelMapper call");
        i++;
        System.out.println("i : " + i);
        return new ModelMapper();
    }

    @Bean(name = "objConfigModelMapper")
    public ModelMapper modelMapper2(CustomerRepository customerRepository) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration();
        System.out.println("objConfigModelMapper call");
        i++;
        System.out.println("i : " + i);
        return modelMapper;
    }

    @Bean
    public SecurityUtil securityUtil(HttpServletRequest httpServletRequest) {
        return new SecurityUtil();
    }


    //Rest Template
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return new RestTemplate();

    }}