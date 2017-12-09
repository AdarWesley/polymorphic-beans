package com.amdocs.example.polymorphicbeans.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amdocs.example.polymorphicbeans.implementation.MyService;
import com.amdocs.example.polymorphicbeans.interfaces.IMyService;

@Configuration
public class CoreConfiguration {
	
	@Bean
	IMyService myService() {
		return new MyService();
	}
}
