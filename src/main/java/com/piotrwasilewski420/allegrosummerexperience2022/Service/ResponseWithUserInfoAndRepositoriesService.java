package com.piotrwasilewski420.allegrosummerexperience2022.Service;

import com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses.ApiResponseForUserWithAggregatedRepos;
import com.piotrwasilewski420.allegrosummerexperience2022.Credentials.CredentialsVault;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ResponseWithUserInfoAndRepositoriesService {
    private final fetchingUserDataService userDataService;
    private final fetchingReposService reposService;

    public ApiResponseForUserWithAggregatedRepos composeResponse(String githubusername) {
        ApiResponseForUserWithAggregatedRepos response = new ApiResponseForUserWithAggregatedRepos();
        response.setUserInfo(userDataService.composeResponse(githubusername));
        //adding repositories to user_info
        response.setRepositories(reposService.composeApiResponseFromRepoAndLanguages(githubusername));
        return response;
    }
}