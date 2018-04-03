package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Persistance;

public class PersistanceMySQL implements Persistance {
	@Override
	public String getType() {
		return "MySQL Persistance";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
