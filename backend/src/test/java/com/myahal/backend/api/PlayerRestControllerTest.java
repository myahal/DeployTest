package com.myahal.backend.api;

import com.myahal.backend.domain.Player;
import com.myahal.backend.service.PlayerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PlayerRestControllerTest {
    @Mock
    private PlayerService playerService;
    @InjectMocks
    private PlayerRestController playerRestController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(playerRestController).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCustomers() throws Exception{
        List<Player> customers = List.of(
                new Player(1, "Ray", "Ayanami"),
                new Player(2, "Asuka", "Langray"),
                new Player(3, "Shinji", "Ikari")
        );
        Mockito.when(playerRestController.getPlayers()).thenReturn(customers);

        mockMvc.perform(get("/api/players")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].firstName", equalTo("Ray")))
                .andExpect(jsonPath("$[0].lastName", equalTo("Ayanami")));
    }
}
