package com.rays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ORSProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ORSProjectApplication.class, args);
	}
	
}
//	public WebMvcConfigurer coreConfig() {
//		WebMvcConfigurer w = new WebMvcConfigurer() {
//			
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//				.allowedOrigins("httplocalhost:42000")
//				.allowedMethods("GET, POST, PUT, DELETE, OPTIONS")
//				.allowedHeaders("*")
//				.allowCredentials(true);
//				
//			}
//		};
//		return w;
//		
//	}


