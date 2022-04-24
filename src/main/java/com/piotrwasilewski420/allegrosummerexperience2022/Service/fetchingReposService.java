package com.piotrwasilewski420.allegrosummerexperience2022.Service;

import com.piotrwasilewski420.allegrosummerexperience2022.Credentials.CredentialsVault;
import com.piotrwasilewski420.allegrosummerexperience2022.DTO.GithubApiRepositoriesResponseDTO;
import com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses.ApiResponseForRepos;
import com.piotrwasilewski420.allegrosummerexperience2022.ApiResponses.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@RequiredArgsConstructor
public class fetchingReposService {
    private final WebClient webClient;
    private String username = CredentialsVault.USERNAME;
    private String password = CredentialsVault.PASSWORD;
    public List<GithubApiRepositoriesResponseDTO> getRepos(String githubUsername){
        GithubApiRepositoriesResponseDTO[] response;
        response = webClient.get()
                .uri("https://api.github.com/users/"+ githubUsername +"/repos")
                .headers(headers -> headers.setBasicAuth(username, password))
                .retrieve()
                .bodyToMono(GithubApiRepositoriesResponseDTO[].class)
                .block();
        if (response == null){
            return new ArrayList<>();
        } else {
            return Arrays.stream(response).toList();
        }
    }

    public Map<String, Integer> getLanguagesFromResponseDTO(GithubApiRepositoriesResponseDTO response){
        Map<String,Integer> languageMap;
        languageMap = webClient.get()
                .uri(response.getLanguagesUri())
                .headers(headers -> headers.setBasicAuth(username, password))
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
        return languageMap;
    }

    public List<ApiResponseForRepos> composeApiResponseFromRepoAndLanguages(String username){
        List<ApiResponseForRepos> apiResponse = new ArrayList();
        List<GithubApiRepositoriesResponseDTO> listOfDTOS = getRepos(username);
        listOfDTOS.forEach(element -> {
            List<Language> finalLanguageList = new ArrayList<>();
            ApiResponseForRepos apiResponseForRepos = new ApiResponseForRepos();
            apiResponseForRepos.setRepoName(element.getName());
            Map<String,Integer> mapOfLanguages = getLanguagesFromResponseDTO(element);
            if (mapOfLanguages.isEmpty()){
                apiResponseForRepos.setLanguages(new ArrayList<>());
            } else {
                mapOfLanguages.forEach((name, bytes) -> {
                    Language language = new Language();
                    language.setLangName(name);
                    language.setBytes(bytes);
                    finalLanguageList.add(language);
                    apiResponseForRepos.setLanguages(finalLanguageList);
                });
                apiResponse.add(apiResponseForRepos);
            }
    });
    return apiResponse;
    }
}