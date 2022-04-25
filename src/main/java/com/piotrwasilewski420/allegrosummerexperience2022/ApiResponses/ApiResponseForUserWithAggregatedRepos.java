package com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.piotrwasilewski420.allegrosummerexperience2022.DTO.UserInfo;
import lombok.Data;

import java.util.List;
@Data
@JsonPropertyOrder({ "user_info", "repositories"})
public class ApiResponseForUserWithAggregatedRepos {
    @JsonProperty("user_info")
    private UserInfo userInfo;
    private List<ApiResponseForRepos> repositories;
}
