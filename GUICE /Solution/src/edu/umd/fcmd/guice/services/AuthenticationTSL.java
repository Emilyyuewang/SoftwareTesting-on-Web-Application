package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Authentication;

public class AuthenticationTSL implements Authentication {
	@Override
	public String getType() {
		return "TSL Authentication";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
