package com.equilibria.api_gateways.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class appconfig {

    @Bean
    public RestTemplate template(){
       return new RestTemplate();
    }

}
