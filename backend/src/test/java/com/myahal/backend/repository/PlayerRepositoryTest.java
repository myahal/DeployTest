package com.myahal.backend.repository;

import com.myahal.backend.domain.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {PlayerRepository.class})
public class PlayerRepositoryTest {
    @Autowired
    PlayerRepository playerRepository;

    @Test
    @Sql({"/two_users.sql"})
    void findAll_2users() {
        List<Player> players = playerRepository.findAll();
        System.out.println(players);
        assertEquals(2, players.size());
    }

    @Test
    @Sql({"/three_users.sql"})
    void findAll_3users() {
        List<Player> players = playerRepository.findAll();
        System.out.println(players);
        assertEquals(3, players.size());
    }
}
