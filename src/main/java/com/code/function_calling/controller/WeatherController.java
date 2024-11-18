package com.code.function_calling.controller;

import com.code.function_calling.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/chat")
public class WeatherController {

    @Autowired
    AIService aiService;

    @PostMapping("/query")
    public Map<String,String> getWeatherDetail(@RequestParam String query) {
        return Map.of("response", aiService.getWeatherInfo(query).getResult().getOutput().getContent());
    }
}
