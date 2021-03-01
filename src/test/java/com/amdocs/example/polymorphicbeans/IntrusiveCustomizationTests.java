package com.amdocs.example.polymorphicbeans;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import com.amdocs.example.polymorphicbeans.interfaces.ExitPoint;
import com.amdocs.example.polymorphicbeans.interfaces.ExitPointWrapper;
import com.amdocs.example.polymorphicbeans.interfaces.ICoreExitPointEnabledService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PolymorphicBeansApplication.class, IntrusiveCustomizationTests.IntrusiveCustomizationTestsConfiguration.class})
public class IntrusiveCustomizationTests {

	@Autowired
	ICoreExitPointEnabledService coreService;
	
	@Autowired
	ExitPointWrapper exitPointWrapper;
	
	@Autowired
	@Qualifier("doServiceAfter")
	ExitPoint<?> doServiceAfterExitPoint;
	
	@Test
	public void CanCallServiceWithExitPoint() {
		assertNotNull(coreService);
		
		coreService.doService();
		
		Mockito.verify(exitPointWrapper, times(1)).invoke("doService", null);
	}
		
	@Test
	public void CanCallServiceWithExitPointImplementation() {
		assertNotNull(coreService);
		Mockito.doNothing().when(doServiceAfterExitPoint).execute(null);
		
		coreService.doService();
		
		Mockito.verify(doServiceAfterExitPoint, times(1)).execute(null);
	}
		
	@TestConfiguration
	public static class IntrusiveCustomizationTestsConfiguration {
		@Bean
		@Primary
		ExitPointWrapper exitPointWrapperSpy(ExitPointWrapper exitPointWrapper) {
			return Mockito.spy(exitPointWrapper);
		}
		
		@Bean
		@Qualifier("doServiceAfter")
		ExitPoint<?> doServiceAfterExitPoint() {
			return Mockito.mock(ExitPoint.class);
		}
	}
}
