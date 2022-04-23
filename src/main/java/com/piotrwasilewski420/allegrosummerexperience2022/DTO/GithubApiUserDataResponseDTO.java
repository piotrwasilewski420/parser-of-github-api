package com.piotrwasilewski420.allegrosummerexperience2022.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubApiUserDataResponseDTO {
    private String login;
    private String bio;
}
