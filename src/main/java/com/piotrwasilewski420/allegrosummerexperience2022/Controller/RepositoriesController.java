package com.piotrwasilewski420.allegrosummerexperience2022.Controller;

import com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses.ApiResponseForRepos;
import com.piotrwasilewski420.allegrosummerexperience2022.Service.fetchingReposService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RepositoriesController {
    private final fetchingReposService reposService;
    @GetMapping("/{githubUsername}/repos")
    public ResponseEntity getRepos(@PathVariable String githubUsername){
        List<ApiResponseForRepos> response = reposService.composeApiResponseFromRepoAndLanguages(githubUsername);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
