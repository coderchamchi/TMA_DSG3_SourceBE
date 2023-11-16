package com.bezkoder.springjwt.entities;

import java.time.LocalDate;

public class Token {
    private User userid;
    private String token;
    private LocalDate created;
}
