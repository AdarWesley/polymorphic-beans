package com.amdocs.example.polymorphicbeans.implementation;

import com.amdocs.example.polymorphicbeans.interfaces.IByTypeService;

public class Type2Service implements IByTypeService {

	@Override
	public String execute() {
		return "Type2";
	}

}
