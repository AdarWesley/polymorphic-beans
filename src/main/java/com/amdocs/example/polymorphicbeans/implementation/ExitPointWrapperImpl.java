package com.amdocs.example.polymorphicbeans.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amdocs.example.beans.factory.annotation.BeanFactoryAnnotationUtilsExtention;
import com.amdocs.example.polymorphicbeans.interfaces.ExitPoint;
import com.amdocs.example.polymorphicbeans.interfaces.ExitPointWrapper;

public class ExitPointWrapperImpl implements ExitPointWrapper {

	@Autowired
	AnnotationConfigApplicationContext ctx;
		
	@Override
	public <ParamType> void invoke(String exitPointQualifier, ParamType param) {
		ExitPoint<ParamType> exitPoint = BeanFactoryAnnotationUtilsExtention.qualifiedBeanOfType(ctx.getBeanFactory(), ExitPoint.class, exitPointQualifier, false);
		if (exitPoint != null) {
			exitPoint.execute(param);
		}
	}
}
