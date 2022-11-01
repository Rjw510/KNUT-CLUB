package com.KNUTCLUB;

import com.KNUTCLUB.repository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class KnutClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnutClubApplication.class, args);
	}
}
