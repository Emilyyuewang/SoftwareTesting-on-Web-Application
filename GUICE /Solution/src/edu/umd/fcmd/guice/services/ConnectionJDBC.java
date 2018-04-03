package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Connection;

public class ConnectionJDBC implements Connection {
	@Override
	public String getType() {
		return "JDBC Connection";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
