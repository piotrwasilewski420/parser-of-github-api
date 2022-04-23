package com.piotrwasilewski420.allegrosummerexperience2022.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubApiRepositoriesResponseDTO {
    private String name;
    @JsonProperty("languages_url")
    private String languagesUri;
}
