package com.amdocs.example.polymorphicbeans.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;
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

	@Autowired
	ConfigurableApplicationContext ctx;
	
	@Bean
	ICustomizableBean customizedCustomizableBean(ICustomizableBean coreBean) {
		CustomizedBean customizedBean = new CustomizedBean(coreBean);
		((BeanDefinitionRegistry)ctx.getBeanFactory()).removeBeanDefinition("customizableBean");
		ctx.getBeanFactory().registerSingleton("customizableBean", customizedBean);
		return customizedBean;
	}

}
