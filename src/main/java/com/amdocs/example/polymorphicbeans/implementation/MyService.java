package com.amdocs.example.polymorphicbeans.implementation;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amdocs.example.beans.factory.annotation.BeanFactoryAnnotationUtilsExtention;
import com.amdocs.example.polymorphicbeans.interfaces.IByTypeService;
import com.amdocs.example.polymorphicbeans.interfaces.ICustomizableBean;
import com.amdocs.example.polymorphicbeans.interfaces.IMyService;

public class MyService implements IMyService {

	@Autowired
	AnnotationConfigApplicationContext ctx;
	
	IByTypeService byTypeService;
	
	@Autowired
	ICustomizableBean customizableBean;
	
	@Override
	public String DoByType(String type) {
		byTypeService = BeanFactoryAnnotationUtilsExtention.qualifiedBeanOfType(ctx.getBeanFactory(), IByTypeService.class, type);		
		return byTypeService.execute();
	}

	@Override
	public String callOverridenBean(String value) {
		return customizableBean.doSomething(value);
	}
}
