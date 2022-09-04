package org.example.kreta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableWebMvc
@SpringBootApplication
public class KretaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KretaApplication.class, args);
	}

	// https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
	// http://localhost:8888/v2/api-docs
	@Configuration
	public class SpringFoxConfig {
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.any())
					.paths(PathSelectors.any())
					.build();
		}
	}
}
