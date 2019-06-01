package ru.vsu.cs.smart.auth.requests;

import lombok.Data;

@Data
public class Credentials {
    private String email;
    private String password;
}
