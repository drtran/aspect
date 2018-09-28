package com.drkiettran.aspect.simple;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

	public void resetEnteringCalledFlag() {
		enteringCalled = false;
	}

	public boolean isEnteringCalled() {
		return enteringCalled;
	}

	Logger logger = LoggerFactory.getLogger(TracingAspect.class);

	boolean enteringCalled = false;

	@Before("execution(* *(..))") // Point cut
	public void entering(JoinPoint joinPoint) { // advice
		enteringCalled = true;
		logger.trace("entering " + joinPoint.getStaticPart().getSignature().toString());
	}

}
