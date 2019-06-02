package ru.vsu.cs.smart.auth.requests;

import lombok.Data;

@Data
public class Credentials {
    private String username;
    private String password;
}
