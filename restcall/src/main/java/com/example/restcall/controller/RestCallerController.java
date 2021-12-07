package com.example.restcall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class RestCallerController {
    @GetMapping("/manufacturers") // http://localhost:9095/api/manufacturers
    public String doCallManufacturer() throws Exception {
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject("http://localhost:9094/api/reports/manufacturers", String.class);
            System.out.println(response);
        }
        return "Call  Completed";
    }

    @GetMapping("/phones") // http://localhost:9095/api/phones
    public String doCallPhone() throws Exception {
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject("http://localhost:9094/api/reports/phones", String.class);
            System.out.println(response);
        }
        return "Call  Completed";
    }
    @GetMapping("/ratelimitDemo") // http://localhost:9095/api/ratelimitDemo
    public String rateLimit() throws Exception {
        for (int i = 0; i <30; i++) {
            Thread.sleep(1000);
            RestTemplate restTemplate1 = new RestTemplate();
            String response1 = restTemplate1.getForObject("http://localhost:9094/api/reports/ratelimiter", String.class);
            System.out.println(response1);
        }
        return "Ratelimit validation";
    }
}
