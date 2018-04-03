package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Middleware;

public class MiddlewareTomcat implements Middleware {
	@Override
	public String getType() {
		return "Tomcat Middleware";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
