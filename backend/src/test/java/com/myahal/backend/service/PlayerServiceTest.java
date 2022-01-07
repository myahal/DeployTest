package com.myahal.backend.service;

import com.myahal.backend.domain.Player;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class PlayerServiceTest {
    @InjectMocks
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test findAll Success")
    void findAll() {
        List<Player> result = playerService.findAll();

        Assertions.assertEquals(2, result.size());
    }
}
