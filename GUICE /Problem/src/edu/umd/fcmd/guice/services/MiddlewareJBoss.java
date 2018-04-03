package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Middleware;

public class MiddlewareJBoss implements Middleware {
	@Override
	public String getType() {
		return "JBoss Middleware";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
