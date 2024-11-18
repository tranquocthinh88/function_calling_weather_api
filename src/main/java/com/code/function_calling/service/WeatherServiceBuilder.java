package com.code.function_calling.service;

import com.code.function_calling.dto.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherServiceBuilder {

    @Value("${spring.weather.api.base.uri}")
    private String weatherBaseUri;
    @Value("${spring.weather.api.key}")
    private String weatherApiKey;

    private RestClient restClient = RestClient.create();

    public Weather.Response getWeather(String city) {
        return restClient.get()
                .uri(UriComponentsBuilder.fromUriString(weatherBaseUri)
                        .path("/current.json")
                        .queryParam("key", weatherApiKey)
                        .queryParam("q", city)
                        .toUriString())
                .retrieve()
                .body(Weather.Response.class);
    }
}
