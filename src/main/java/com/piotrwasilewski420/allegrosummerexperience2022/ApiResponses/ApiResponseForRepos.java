package com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.piotrwasilewski420.allegrosummerexperience2022.DTO.Language;
import lombok.Data;

import java.util.List;
@Data
@JsonPropertyOrder({ "repository_name", "languages"})
public class ApiResponseForRepos {
    @JsonProperty("repository_name")
    private String repoName;
    private List<Language> languages;
}
