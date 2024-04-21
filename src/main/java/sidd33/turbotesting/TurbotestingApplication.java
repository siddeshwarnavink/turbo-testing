package sidd33.turbotesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "sidd33.turbotesting", "sidd33.turboengine.forms" })
public class TurbotestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbotestingApplication.class, args);
	}

}
