package bg.proba.firstrproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class OurFirstSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurFirstSpringProjectApplication.class, args);
	}

}
