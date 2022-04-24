package com.piotrwasilewski420.allegrosummerexperience2022.Service;

import com.piotrwasilewski420.allegrosummerexperience2022.DTO.GithubApiUserDataResponseDTO;
import com.piotrwasilewski420.allegrosummerexperience2022.Entity.ApiResponseForUserWithAggregatedRepos;
import com.piotrwasilewski420.allegrosummerexperience2022.Entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
@RequiredArgsConstructor
@Service
public class fetchingUserDataService {
    private final WebClient webClient;
    public GithubApiUserDataResponseDTO getUserInfo(String username) {
        GithubApiUserDataResponseDTO dataResponseDTO;
        dataResponseDTO = webClient.get()
                .uri("https://api.github.com/users/Vengardd")
                .retrieve()
                .bodyToMono(GithubApiUserDataResponseDTO.class)
                .block();
        return dataResponseDTO;
    }
    public ApiResponseForUserWithAggregatedRepos composeResponse(String githubUsername){
        ApiResponseForUserWithAggregatedRepos response = new ApiResponseForUserWithAggregatedRepos();
        UserInfo userInfo = new UserInfo();
        GithubApiUserDataResponseDTO dataResponseDTO = getUserInfo(githubUsername);
        userInfo.setLogin(dataResponseDTO.getLogin());
        userInfo.setBio(dataResponseDTO.getBio());
        response.setUserInfo(userInfo);
        return response;
    }
}
