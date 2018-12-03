package com.amdocs.example.polymorphicbeans.implementation;

import com.amdocs.example.polymorphicbeans.interfaces.ICustomizableBean;

public class CoreCustomizableBean implements ICustomizableBean {

	@Override
	public String doSomething(String value) {
		return "core("+ value + ")";
	}

}
