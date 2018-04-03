package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Connection;

public class ConnectionPooled implements Connection {
	@Override
	public String getType() {
		return "Pooled Connection";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
