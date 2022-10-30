package com.KNUTCLUB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class KnutClubApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(KnutClubApplication.class, args);
	}
}
