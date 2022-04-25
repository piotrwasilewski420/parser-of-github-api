package com.piotrwasilewski420.allegrosummerexperience2022.Controller;

import com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses.ApiResponseForUserWithAggregatedRepos;
import com.piotrwasilewski420.allegrosummerexperience2022.Service.ResponseWithUserInfoAndRepositoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserWithAggregatedReposController {
    private final ResponseWithUserInfoAndRepositoriesService infoAndRepositoriesService;
    @GetMapping("/{githubusername}")
    public ResponseEntity getUserWithAggregatedInfo(@PathVariable String githubusername){
        ApiResponseForUserWithAggregatedRepos response = new ApiResponseForUserWithAggregatedRepos();
        response = infoAndRepositoriesService.composeResponse(githubusername);
    return new ResponseEntity(response, HttpStatus.OK);
    }
}
