package com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Language {
    @JsonProperty("language_name")
    private String langName;
    private Integer bytes;
}
