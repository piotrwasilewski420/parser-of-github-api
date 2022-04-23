package com.piotrwasilewski420.allegrosummerexperience2022.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Language {
    @JsonProperty("language_name")
    private String langName;
    private Integer bytes;
}
