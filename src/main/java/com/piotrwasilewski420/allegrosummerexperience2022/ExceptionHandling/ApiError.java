package com.piotrwasilewski420.allegrosummerexperience2022.ExceptionHandling;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiError {
    @JsonProperty("message")
    private String messageName;
}
