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
	
	
}
