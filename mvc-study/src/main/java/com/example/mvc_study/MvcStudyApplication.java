package com.example.mvc_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MvcStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcStudyApplication.class, args);
	}

}
