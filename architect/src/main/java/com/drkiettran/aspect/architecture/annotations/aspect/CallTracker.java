package com.drkiettran.aspect.architecture.annotations.aspect;

public class CallTracker {

	private boolean called;

	public boolean isCalled() {
		return called;
	}

	public void resetCalled() {
		called=false;
	}
	
	protected void trackCall() {
		called=true;
	}

}
