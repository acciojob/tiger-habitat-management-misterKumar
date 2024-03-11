package com.driver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TigerConfig {

    @Bean
    public Tiger bengalTiger() {
        return new BengalTiger();
    }

    @Bean
    public Tiger siberianTiger() {
        return new SiberianTiger();
    }

    @Bean
    public Tiger sumatranTiger() {
        return new SumatranTiger();
    }

    @Bean
    public TigerHabitat tigerHabitat() {
        return new TigerHabitat();
    }
}

