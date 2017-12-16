package com.amdocs.example.polymorphicbeans.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.amdocs.example.polymorphicbeans.implementation.MyService;
import com.amdocs.example.polymorphicbeans.implementation.Type1Service;
import com.amdocs.example.polymorphicbeans.implementation.Type2Service;
import com.amdocs.example.polymorphicbeans.implementation.Type3Service;
import com.amdocs.example.polymorphicbeans.interfaces.IByTypeService;
import com.amdocs.example.polymorphicbeans.interfaces.IMyService;

@Configuration
@Order(1)
public class CoreConfiguration {
	
	@Bean
	IMyService myService() {
		return new MyService();
	}
	
	@Bean
	@Qualifier("Type1")
	IByTypeService type1Service() {
		return new Type1Service();
	}
	
	@Bean
	@Qualifier("Type2")
	IByTypeService type2Service() {
		return new Type2Service();
	}
	
	@Bean
	@Qualifier("Type3")
	IByTypeService type3Service() {
		return new Type3Service();
	}
}
