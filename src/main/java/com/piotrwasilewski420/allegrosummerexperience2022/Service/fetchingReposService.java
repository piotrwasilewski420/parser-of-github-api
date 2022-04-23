package com.piotrwasilewski420.allegrosummerexperience2022.Service;

import com.piotrwasilewski420.allegrosummerexperience2022.DTO.GithubApiRepositoriesResponseDTO;
import com.piotrwasilewski420.allegrosummerexperience2022.Entity.ApiResponseForRepos;
import com.piotrwasilewski420.allegrosummerexperience2022.Entity.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@RequiredArgsConstructor
public class fetchingReposService {
    private final WebClient webClient;

    public List<GithubApiRepositoriesResponseDTO> getRepos(String githubUsername){
        GithubApiRepositoriesResponseDTO[] response;
        response = webClient.get()
                .uri("https://api.github.com/users/"+ githubUsername +"/repos")
                .retrieve()
                .bodyToMono(GithubApiRepositoriesResponseDTO[].class)
                .block();
        return Arrays.stream(response).toList();
    }

    public Map<String, Integer> getLanguagesFromResponseDTO(GithubApiRepositoriesResponseDTO response){
        Map<String,Integer> languageMap;
        languageMap = webClient.get()
                .uri(response.getLanguagesUri())
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
            mapOfLanguages.forEach((name,bytes) -> {
                Language language = new Language();
                language.setLangName(name);
                language.setBytes(bytes);
                System.out.println(language);
                finalLanguageList.add(language);
                apiResponseForRepos.setLanguages(finalLanguageList);
            });
            System.out.println(apiResponse);
            apiResponse.add(apiResponseForRepos);
        });
       return apiResponse;
    }
}
