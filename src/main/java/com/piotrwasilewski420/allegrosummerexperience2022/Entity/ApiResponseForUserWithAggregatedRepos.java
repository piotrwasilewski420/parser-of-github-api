package com.piotrwasilewski420.allegrosummerexperience2022.Entity;

import lombok.Data;

import java.util.List;
@Data
public class ApiResponseForUserWithAggregatedRepos {
    private String login;
    private String name;
    private String bio;
    private List<ApiResponseForRepos> repositories;
}
