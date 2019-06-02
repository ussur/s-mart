package ru.vsu.cs.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SMartApplication {
	public static void main(String[] args) {
		SpringApplication.run(SMartApplication.class, args);
	}
}
