package com.amdocs.example.polymorphicbeans;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.amdocs.example.polymorphicbeans.interfaces.IMyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolymorphicBeansApplicationTests {

	@Autowired
	IMyService myService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void canLoadServiceBean() {
		assertNotNull(myService);
	}
	
	@Test
	public void canCallServiceWithCoreType1() {
		String type = myService.DoByType("Type1");
		
		assertEquals("Type1", type);
	}
	
	@Test
	public void canCallServiceWithCoreType2() {
		String type = myService.DoByType("Type2");
		
		assertEquals("Type2", type);
	}
	
	@Test
	public void canCallServiceWithCoreType3() {
		String type = myService.DoByType("Type3");
		
		assertEquals("Type3", type);
	}
	
	@Test
	public void canOverrideCoreByCustomizationAndAccessCoreBean() {
		String value = myService.callOverridenBean("value");
		
		assertEquals("Customized(core(value))", value);
	}
}
