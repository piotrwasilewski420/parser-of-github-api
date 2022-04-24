package com.piotrwasilewski420.allegrosummerexperience2022.Controller;

import com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses.ApiResponseForUserWithAggregatedRepos;
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
    @GetMapping("/{githubusername}")
    public ResponseEntity getUserWithAggregatedInfo(@PathVariable String githubusername){
        System.out.println(githubusername);
        ApiResponseForUserWithAggregatedRepos response = userDataService.composeResponse(githubusername);
        //adding repositories to user_info
        response.setRepositories(reposService.composeApiResponseFromRepoAndLanguages(githubusername));
    return new ResponseEntity(response, HttpStatus.OK);
    }
}
