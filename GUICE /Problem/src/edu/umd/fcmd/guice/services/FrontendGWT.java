package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Frontend;

public class FrontendGWT implements Frontend {
	@Override
	public String getType() {
		return "GWT Frontend";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
