package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Persistance;

public class PersistanceOracle implements Persistance {
	@Override
	public String getType() {
		return "Oracle Persistance";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
