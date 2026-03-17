package com.aiintegration.ai.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.aiintegration.ai.service.OpenAiService;

@RestController
@RequestMapping("/api")
public class AiController {

    private final OpenAiService aiService;

    public AiController(OpenAiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping(value = "/ask-ai", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String ask(@RequestParam String prompt) {
        System.out.println("Controller hit with prompt: " + prompt);
        return aiService.generateResponse(prompt);
    }
}