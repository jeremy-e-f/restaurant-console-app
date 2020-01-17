package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// Le stéréotype @Configuration précise que cette classe servira de configuration.
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("dev")
@PropertySource("app.properties")
public class AppConfig {
	
	@Bean
	Scanner scanner(){
		return new Scanner(System.in);
	}
	
}
