package com.myahal.backend.service;

import com.myahal.backend.domain.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    public List<Player> findAll() {
        return List.of(
                new Player(1, "Nobita", "Nobi"),
                new Player(2, "Takeshi", "Goda")
        );
    }
}
