package com.piotrwasilewski420.allegrosummerexperience2022.webMVCTests;

import com.piotrwasilewski420.allegrosummerexperience2022.Controller.RepositoriesController;
import com.piotrwasilewski420.allegrosummerexperience2022.Service.fetchingReposService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@RequiredArgsConstructor
@WebMvcTest(RepositoriesController.class)
public class RepositoriesControllerTests {
    @MockBean
    private final fetchingReposService reposService;
    private final MockMvc mockMvc;
    @Test
    void should_get_repositories(){

    }
}
