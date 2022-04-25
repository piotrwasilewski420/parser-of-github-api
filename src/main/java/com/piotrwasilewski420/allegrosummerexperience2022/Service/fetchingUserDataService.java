package com.piotrwasilewski420.allegrosummerexperience2022.Service;

import com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses.ApiResponseForUserWithAggregatedRepos;
import com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses.UserInfo;
import com.piotrwasilewski420.allegrosummerexperience2022.Credentials.CredentialsVault;
import com.piotrwasilewski420.allegrosummerexperience2022.DTO.GithubApiRepositoriesResponseDTO;
import com.piotrwasilewski420.allegrosummerexperience2022.DTO.GithubApiUserDataResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service
public class fetchingUserDataService {
    private final WebClient webClient;

    private String username = CredentialsVault.USERNAME;
    private String password = CredentialsVault.PASSWORD;
    public GithubApiUserDataResponseDTO fetchData(String githubUsername) {
        return  webClient.get()
                .uri("https://api.github.com/users/"+githubUsername)
                .headers(headers -> headers.setBasicAuth(username, password))
                .retrieve()
                .bodyToMono(GithubApiUserDataResponseDTO.class)
                .block();
    }
    public UserInfo composeResponse(String githubusername) {
        UserInfo userInfo = new UserInfo();
        GithubApiUserDataResponseDTO dataResponseDTO = fetchData(githubusername);
        String login = dataResponseDTO.getLogin().orElse("");
        String bio = dataResponseDTO.getBio().orElse("");
        String name = dataResponseDTO.getName().orElse("");
        userInfo.setBio(bio);
        userInfo.setLogin(login);
        userInfo.setName(name);
        return userInfo;
    }
}
