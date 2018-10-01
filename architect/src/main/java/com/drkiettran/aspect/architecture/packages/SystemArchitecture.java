package com.drkiettran.aspect.architecture.packages;

import org.aspectj.lang.annotation.Pointcut;

public class SystemArchitecture {

	@Pointcut("execution(* com.drkiettran..repository.*Repository.*(..))")
	public void Repository() {
	}

	@Pointcut("execution(* com.drkiettran..service.*.*(..))")
	public void Service() {
	}

}
