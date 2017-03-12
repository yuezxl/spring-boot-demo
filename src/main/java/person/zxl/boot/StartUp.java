package person.zxl.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import person.zxl.boot.config.WebConfigure;

@SpringBootApplication
@PropertySource({ "classpath:boot-config.properties", "classpath:important.properties" })
@Import({ WebConfigure.class })
@ImportResource({ "classpath:spring/spring-base.xml" })
@ComponentScan({ "person.zxl" })
public class StartUp extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(StartUp.class);
		application.run(args);
	}
}	
