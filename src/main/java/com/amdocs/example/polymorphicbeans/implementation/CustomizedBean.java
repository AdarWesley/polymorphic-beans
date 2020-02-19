package com.amdocs.example.polymorphicbeans.implementation;

import com.amdocs.example.polymorphicbeans.interfaces.ICustomizableBean;

public class CustomizedBean implements ICustomizableBean {

	private ICustomizableBean coreBean;

	public CustomizedBean(ICustomizableBean coreBean) {
		this.coreBean = coreBean;
	}
	
	@Override
	public String doSomething(String value) {
		return "Customized(" + coreBean.doSomething(value) + ")";
	}

}
