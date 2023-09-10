package com.example;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public MyObject myObject(){
        return new MyObject("Yashpal" , 23);
    }
}
