package com.pivotal;
/*
 * @author Naveen K Wodeyar
 * @date 23/06/2024
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
				title = "SPRING_BOOT",
				version = "1.0",
				description = "Spring Boot demo project for spring_boot,",
				termsOfService = "http://terms.example.com",
				contact = @Contact(
						name = "Naveen K Wodeyar",
						email = "naveen.wodeyar@yahoo.com",
						url = "http://naveenwodeyar.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0.html"
				)
		),
		servers = {
				@Server(
						url = "http://localhost:8899",
						description = "Developer testing/environment server",
						variables = {
								@ServerVariable(
										name = "port",
										description = "Port number",
										defaultValue = "8899"
								)
						}
				),
				@Server(
						url = "http://production-server.com",
						description = "Production server/environment"
				)
		},
		externalDocs = @ExternalDocumentation(
				description = "Find more info here",
				url = "http://example.com/docs"
		)
)
public class SbStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbStarterApplication.class, args);
		System.out.println("SpringSource,\n Pivotal,\n Rod Johnson");
	}

}
