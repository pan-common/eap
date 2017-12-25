package com.taiji.eap.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Util {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
