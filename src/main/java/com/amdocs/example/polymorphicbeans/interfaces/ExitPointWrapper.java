package com.amdocs.example.polymorphicbeans.interfaces;

public interface ExitPointWrapper {

	<ParamType> void invoke(String exitPointQualifier, ParamType param);

}
