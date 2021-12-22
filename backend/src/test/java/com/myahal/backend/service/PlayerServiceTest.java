package com.myahal.backend.service;

import com.myahal.backend.domain.Player;
import com.myahal.backend.repository.PlayerRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class PlayerServiceTest {
    @InjectMocks
    private PlayerService playerService;
    @Mock
    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test findAll Success")
    void findAll() {
        Player player = new Player(1, "Ichiro", "Sato");
        Mockito.doReturn(List.of(player)).when(playerRepository).findAll();

        List<Player> result = playerService.findAll();

        Assertions.assertEquals(1, result.size());
    }
}
