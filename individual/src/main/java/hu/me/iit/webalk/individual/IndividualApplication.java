package hu.me.iit.webalk.individual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IndividualApplication {
	//http://localhost:8080/v3/api-docs			http://localhost:8080/swagger-ui/index.html
	public static void main(String[] args) {
		SpringApplication.run(IndividualApplication.class, args);
	}

}
