package com.piotrwasilewski420.allegrosummerexperience2022.Controller;

import com.piotrwasilewski420.allegrosummerexperience2022.Entity.ApiResponseForUserWithAggregatedRepos;
import com.piotrwasilewski420.allegrosummerexperience2022.Service.fetchingReposService;
import com.piotrwasilewski420.allegrosummerexperience2022.Service.fetchingUserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserWithAggregatedReposController {
    private final fetchingUserDataService userDataService;
    private final fetchingReposService reposService;
    @GetMapping("/{githubUsername}")
    public ResponseEntity getUserWithAggregatedInfo(@PathVariable String githubUsername){
        ApiResponseForUserWithAggregatedRepos response = userDataService.composeResponse(githubUsername);
        //adding repositories to user_info
        response.setRepositories(reposService.composeApiResponseFromRepoAndLanguages(githubUsername));
    return new ResponseEntity(response, HttpStatus.OK);
    }
}
