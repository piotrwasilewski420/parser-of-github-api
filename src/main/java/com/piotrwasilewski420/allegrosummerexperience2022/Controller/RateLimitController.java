package com.piotrwasilewski420.allegrosummerexperience2022.Controller;

import com.piotrwasilewski420.allegrosummerexperience2022.Service.FindingRateLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RateLimitController {
    private final FindingRateLimitService rateLimitService;

    @GetMapping("/test")
    public ResponseEntity getRateLimit(){
        Object rateLimit = rateLimitService.getRateLimit();
        return new ResponseEntity(rateLimit, HttpStatus.OK);
    }
}
