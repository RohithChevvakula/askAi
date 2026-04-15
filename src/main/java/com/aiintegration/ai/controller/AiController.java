package com.aiintegration.ai.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.aiintegration.ai.service.OpenAiService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ask-ai")
public class AiController {

    private final OpenAiService aiService;

    public AiController(OpenAiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String ask(@RequestParam String prompt) {
        System.out.println("Controller V1 hit with prompt: " + prompt);
        return aiService.generateResponse(prompt);
    }   
}