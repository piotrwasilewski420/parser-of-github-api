package com.piotrwasilewski420.allegrosummerexperience2022.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class ApiResponseForRepos {
    @JsonProperty("repository_name")
    private String repoName;
    private List<Language> languages;
}
