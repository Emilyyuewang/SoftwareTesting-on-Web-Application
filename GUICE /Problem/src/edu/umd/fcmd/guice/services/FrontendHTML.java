package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Frontend;

public class FrontendHTML implements Frontend {
	@Override
	public String getType() {
		return "HTML Frontend";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
