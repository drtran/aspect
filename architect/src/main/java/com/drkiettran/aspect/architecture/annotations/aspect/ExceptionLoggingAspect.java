package com.drkiettran.aspect.architecture.annotations.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLoggingAspect extends CallTracker {

	Logger logger = LoggerFactory.getLogger(ExceptionLoggingAspect.class);

	@AfterThrowing(pointcut = "com.drkiettran.aspect.architecture.annotations.SystemArchitecture.Repository() || com.drkiettran.aspect.architecture.annotations.SystemArchitecture.Service()", throwing = "ex")
	public void logException(Exception ex) {
		trackCall();
		logger.error("Exception", ex);
	}

}
