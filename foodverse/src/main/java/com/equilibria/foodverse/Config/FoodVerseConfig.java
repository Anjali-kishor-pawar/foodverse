package com.equilibria.foodverse.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FoodVerseConfig {

    @Bean
    @LoadBalanced
    public RestTemplate template()
    {
        return new RestTemplate();
    }

}
