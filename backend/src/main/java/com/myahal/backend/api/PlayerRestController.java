package com.myahal.backend.api;

import com.myahal.backend.domain.Player;
import com.myahal.backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/players")
@CrossOrigin
public class PlayerRestController {
    @Autowired
    PlayerService playerService;

    @GetMapping
    List<Player> getPlayers() {
        List<Player> customers = playerService.findAll();
        return customers;
    }
}
