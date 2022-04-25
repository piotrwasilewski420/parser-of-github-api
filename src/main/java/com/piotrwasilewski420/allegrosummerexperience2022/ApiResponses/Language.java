package com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"language_name","bytes"})
public class Language {
    @JsonProperty("language_name")
    private String langName;
    private Integer bytes;
}
