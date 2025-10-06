package com.example.args;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class ArgsApplication {

	public static void main(String[] args) throws ParseException {
		try {
			Args arg = new Args("l,p#,d*", args);
			boolean logging = arg.getBoolean('l');
			int port = arg.getInt('p');
			String directory = arg.getString('d');
			executeApplication(logging, port, directory, args);
		} catch (Exception e) {
			System.out.println("Błąd argumentów: %s\n" + e.getMessage());
		}
	}

	public static void executeApplication(boolean logging, int port, String directory, String[] args){
		System.out.println("Logging: " + logging + "\n" + "port: " + port + "\n" + "directory: " + directory);
		SpringApplication.run(ArgsApplication.class, args);
	}
}
