package com.example.codingchallenge.integration;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.StreamUtils;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetPlayerWithLargestGGR() throws Exception {

        ClassPathResource resource = new ClassPathResource("/integration/calculation/getPlayerWithLargestGGR.json");
        String expectedJson = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);

        mockMvc.perform(MockMvcRequestBuilders.get("/players/largest-ggr?page=1&pageSize=30"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));

    }

}
