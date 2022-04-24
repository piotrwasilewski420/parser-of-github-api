package com.piotrwasilewski420.allegrosummerexperience2022.Service;

import com.piotrwasilewski420.allegrosummerexperience2022.Credentials.CredentialsVault;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
public class FindingRateLimitService {
    private String username = CredentialsVault.USERNAME;
    private String password = CredentialsVault.PASSWORD;
    private final WebClient webClient;
    public Object getRateLimit(){
        Object rateLimitDTO;
        rateLimitDTO = webClient.get()
                .uri("https://api.github.com/rate_limit")
                .headers(headers -> headers.setBasicAuth(username, password))
                .retrieve()
                .bodyToMono(Object.class)
                .block();
        System.out.println(rateLimitDTO);
        return rateLimitDTO;
    }
}
