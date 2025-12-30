package com.example.crud_operation;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongoAuditing
public class CrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationApplication.class, args);
	}

}
