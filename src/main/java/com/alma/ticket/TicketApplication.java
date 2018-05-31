package com.alma.ticket;

import com.alma.ticket.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[]{TicketApplication.class, JpaConfig.class}, args);
	}
}
