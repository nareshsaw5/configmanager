package com.nokia.cns.mediation;

import com.nokia.cns.mediation.controller.ConfigManagerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(value = {ConfigManagerController.class})

@SpringBootApplication
public class Start {
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}

}
