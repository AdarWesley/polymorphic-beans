package com.amdocs.example.polymorphicbeans.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

import com.amdocs.example.polymorphicbeans.implementation.CustomizedBean;
import com.amdocs.example.polymorphicbeans.interfaces.ICustomizableBean;

@Configuration
@Import(CoreConfiguration.class)
@Order(2)
public class CustomizationConfiguration {

	@Bean
	ICustomizableBean customizableBean(ICustomizableBean coreBean) {
		return new CustomizedBean(coreBean);
	}

}
