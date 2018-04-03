package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.FileSystem;

public class FileSystemNTFS implements FileSystem {
	@Override
	public String getType() {
		return "NTFS FileSystem";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
