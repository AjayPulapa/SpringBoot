package com.mss.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan()
//@SpringBootApplication
public class SpringbootTasksWsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootTasksWsApplication.class, args);
	}
}
