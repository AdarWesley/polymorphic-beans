package com.amdocs.example.polymorphicbeans.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.amdocs.example.polymorphicbeans.interfaces.ExitPointWrapper;
import com.amdocs.example.polymorphicbeans.interfaces.ICoreExitPointEnabledService;

public class CoreExitPointEnabledService implements ICoreExitPointEnabledService {

	@Autowired
	ExitPointWrapper doServiceExitPoint;
	
	@Override
	public void doService() {
		doServiceExitPoint.invoke("doService", null);
		doServiceExitPoint.invoke("doServiceAfter", null);
	}

}
