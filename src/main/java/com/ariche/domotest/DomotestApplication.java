package com.ariche.domotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DomotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomotestApplication.class, args);
	}

	@RestController
	class PingController {

		@GetMapping("/ping")
		public String ping() {
			return "pong";
		}
	}

}
