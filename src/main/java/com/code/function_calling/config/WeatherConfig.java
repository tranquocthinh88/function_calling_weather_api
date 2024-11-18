package com.code.function_calling.config;

import com.code.function_calling.dto.Weather;
import com.code.function_calling.service.WeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class WeatherConfig {

    @Bean
    @Description("Get the weather city")
    Function<Weather.Request, Weather.Response> currentWeather(){
        return new WeatherService();
    }
}
