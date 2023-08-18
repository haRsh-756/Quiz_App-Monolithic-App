package com.techwork.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author harsh_patel
 * Main application class that launches the Quiz App.
 */
@SpringBootApplication
public class QuizappApplication {

	/**
	 * Main method to start the Quiz App application.
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
	}
}
