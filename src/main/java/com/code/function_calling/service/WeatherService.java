package com.code.function_calling.service;

import com.code.function_calling.dto.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class WeatherService implements Function<Weather.Request, Weather.Response> {

    @Autowired
    WeatherServiceBuilder weatherServiceBuilder;
    @Override
    public Weather.Response apply(Weather.Request request) {
        return weatherServiceBuilder.getWeather(request.city());
    }
}
