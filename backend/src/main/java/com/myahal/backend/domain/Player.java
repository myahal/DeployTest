package com.myahal.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private Integer id;
    private String firstName;
    private String lastName;
}
