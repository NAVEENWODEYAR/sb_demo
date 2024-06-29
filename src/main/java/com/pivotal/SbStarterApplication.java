package com.pivotal;
/*
 * @author Naveen K Wodeyar
 * @date 23/06/2024
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbStarterApplication.class, args);
		System.out.println("SpringSource,Pivotal,Rod Johnson");
	}

}
