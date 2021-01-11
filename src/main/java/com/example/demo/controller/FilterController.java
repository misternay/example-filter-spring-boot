package com.example.demo.controller;

import com.example.demo.model.OnboardingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @PostMapping(path = "/hello")
    public String onBoardingCustomer(@RequestBody OnboardingRequest request) {
        return request.getCitizenNo();
    }
}
