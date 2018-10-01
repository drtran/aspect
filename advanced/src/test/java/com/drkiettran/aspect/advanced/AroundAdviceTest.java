package com.drkiettran.aspect.advanced;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.drkiettran.aspect.advanced.configuration.AdvancedConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdvancedConfiguration.class)
public class AroundAdviceTest {

	@Autowired
	AroundAdvice aroundAspect;

	@Autowired
	SimpleService simpleService;

	@Before
	public void rest() {
		aroundAspect.reset();
	}
	
	@Test
	public void aroundAdviceIsCalledForSimpleMethod() {
		assertFalse(aroundAspect.isCalled());
		simpleService.doSomething();
		assertTrue(aroundAspect.isCalled());
	}

	@Test(expected = RuntimeException.class)
	public void aroundAdviceIsCalledIfExceptionIsThrown() {
		assertFalse(aroundAspect.isCalled());
		try {
			simpleService.throwsRuntimeException();
		} finally {
			assertTrue(aroundAspect.isCalled());
		}
	}

	@Test
	public void aroundAdviceIsCalledIfValueIsReturned() {
		assertFalse(aroundAspect.isCalled());
		assertThat(simpleService.returnsString(), equalTo("42"));
		assertTrue(aroundAspect.isCalled());
	}

}
