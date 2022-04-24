package com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class UserInfo {
    private String login;
    private String name;
    private String bio;
}
