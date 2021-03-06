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
public class ExceptionLoggingAspectTest {

	@Autowired
	ExceptionLoggingAspect exceptionLoggingAspect;

	@Autowired
	MyService myService;

	@Autowired
	MyRepository myRepository;

	@Before
	public void setUp() {
		exceptionLoggingAspect.resetCalled();
	}

	@Test
	public void exceptionLoggingIsNotCalledIfNoExceptionIsThrown() {
		assertFalse(exceptionLoggingAspect.isCalled());
		myRepository.doIt();
		assertFalse(exceptionLoggingAspect.isCalled());
	}

	@Test(expected = RuntimeException.class)
	public void exceptionLoggingIsCalledIfExceptionIsThrown() {
		assertFalse(exceptionLoggingAspect.isCalled());
		try {
			myRepository.throwsException();
		} finally {
			assertTrue(exceptionLoggingAspect.isCalled());
		}
	}

}
