package com.myahal.backend.repository;

import com.myahal.backend.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlayerRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final RowMapper<Player> customerRowMapper = (rs, i) -> {
        Integer id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new Player(id, firstName, lastName);
    };

    public List<Player> findAll() {
        List<Player> players = jdbcTemplate.query(
                "SELECT id, first_name, last_name from players order by id",
                customerRowMapper
        );
        return players;
    }
}
