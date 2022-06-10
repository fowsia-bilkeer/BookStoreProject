package com.qa.starterproject.Library.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qa.starterproject.Library.Service.ModelMapper;



@Configuration
public class AppConfig {
	
	@Bean
	public String stuff() {
		return new String("stuff");
		
	}
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
