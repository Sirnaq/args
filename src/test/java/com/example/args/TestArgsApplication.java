package com.example.args;

import org.springframework.boot.SpringApplication;

public class TestArgsApplication {

	public static void main(String[] args) {
		SpringApplication.from(ArgsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
