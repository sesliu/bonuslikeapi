package br.com.bunuslike.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@ComponentScan(basePackages= {"br.com.bonuslike"})
public class Main extends SpringBootServletInitializer {
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Main.class);
	    }
		
			public static void main(String[] args) throws Exception{
				SpringApplication.run(Main.class, args);
			}
			

}
