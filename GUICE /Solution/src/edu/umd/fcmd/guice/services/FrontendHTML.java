package edu.umd.fcmd.guice.services;

import com.google.inject.Inject;

import edu.umd.fcmd.guice.interfaces.Authentication;
import edu.umd.fcmd.guice.interfaces.Frontend;

public class FrontendHTML implements Frontend {
	private final Authentication authentication;
	
	@Inject
	public FrontendHTML(Authentication aut) {
	this.authentication = aut;}
	
	@Override
	public String getType() {
		return "HTML Frontend";
	}
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		authentication.run();
		return true;
	}
}
