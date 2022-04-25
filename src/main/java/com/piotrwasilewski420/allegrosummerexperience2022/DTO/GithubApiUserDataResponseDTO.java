package com.piotrwasilewski420.allegrosummerexperience2022.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Optional;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubApiUserDataResponseDTO {
    private Optional<String> login;
    private Optional<String> bio;
    private Optional<String> name;
}
