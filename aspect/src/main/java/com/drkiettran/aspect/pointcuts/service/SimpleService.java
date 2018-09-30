package com.drkiettran.aspect.pointcuts.service;

import org.springframework.stereotype.Service;

import com.drkiettran.aspect.pointcuts.annotation.Trace;

@Service
public class SimpleService {

	public void doSomething() {
	}

	@Trace
	public void annotated() {
	}
}
