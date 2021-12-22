package com.myahal.backend.service;

import com.myahal.backend.domain.Player;
import com.myahal.backend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}
