package edu.umd.fcmd.guice.services;

import com.google.inject.Inject;

import edu.umd.fcmd.guice.interfaces.Authentication;
import edu.umd.fcmd.guice.interfaces.Frontend;

public class FrontendGWT implements Frontend {
	private final Authentication authentication;
	@Override
	public String getType() {
		return "GWT Frontend";
	}
	@Inject
	public FrontendGWT(Authentication aut) {
	this.authentication = aut;}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		authentication.run();
		return true;
	}
}
