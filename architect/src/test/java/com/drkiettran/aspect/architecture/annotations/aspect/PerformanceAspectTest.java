package com.drkiettran.aspect.architecture.annotations.aspect;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.drkiettran.aspect.architecture.annotations.repository.MyRepository;
import com.drkiettran.aspect.architecture.annotations.service.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/architecture/annotations/system-configuration.xml")
public class PerformanceAspectTest {

	@Autowired
	PerformanceAspect performanceAspect;

	@Autowired
	MyService myService;

	@Autowired
	MyRepository myRepository;

	@Before
	public void setUp() {
		performanceAspect.resetCalled();
	}

	@Test
	public void performanceIsCalledForRepositories() {
		assertFalse(performanceAspect.isCalled());
		myRepository.doIt();
		assertTrue(performanceAspect.isCalled());
	}

	@Test
	public void performanceIsNotCalledForServices() {
		assertFalse(performanceAspect.isCalled());
		myService.doIt();
		assertFalse(performanceAspect.isCalled());
	}

}
