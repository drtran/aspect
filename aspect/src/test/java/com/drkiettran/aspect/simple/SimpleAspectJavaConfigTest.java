package com.drkiettran.aspect.simple;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.drkiettran.aspect.simple.SimpleService;
import com.drkiettran.aspect.simple.TracingAspect;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.drkiettran.aspect.configuration.SimpleAspectConfiguration.class)
public class SimpleAspectJavaConfigTest {

	@Autowired
	TracingAspect tracingAspect;

	@Autowired
	SimpleService simpleService;

	@Before
	public void setUp() {
		tracingAspect.resetEnteringCalledFlag();
	}

	@Test
	public void aspectIsCalled() {
		assertFalse(tracingAspect.isEnteringCalled());
		simpleService.doSomethingElse(42);
		assertTrue(tracingAspect.isEnteringCalled());
	}

}
