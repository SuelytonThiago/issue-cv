package io.github.suelytonthiago.Issuecv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class IssueCvApplication {


	public static void main(String[] args) {
		SpringApplication.run(IssueCvApplication.class, args);
	}


}
